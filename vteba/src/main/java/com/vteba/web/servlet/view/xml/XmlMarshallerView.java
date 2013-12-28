package com.vteba.web.servlet.view.xml;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.BeansException;
import org.springframework.oxm.Marshaller;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.vteba.common.exception.BasicException;
import com.vteba.service.xml.jibx.JibxMarshallerFactory;

/**
 * Spring MVC XML View，基于JIBX实现。
 * @author yinlei
 * date 2013-9-18 下午8:19:08
 */
public class XmlMarshallerView extends AbstractView {

	/**
	 * Default content type. Overridable as bean property.
	 */
	public static final String DEFAULT_CONTENT_TYPE = "application/xml";

	private Marshaller marshaller;
	
	private JibxMarshallerFactory jibxMarshallerFactory;
	
	private String modelKey;

	/**
	 * Constructs a new {@code XmlMarshallerView} with no {@link Marshaller} set. The marshaller must be set after
	 * construction by invoking {@link #setMarshaller(Marshaller)}.
	 */
	public XmlMarshallerView() {
		setContentType(DEFAULT_CONTENT_TYPE);
		setExposePathVariables(false);
	}

	/**
	 * Constructs a new {@code XmlMarshallerView} with the given {@link Marshaller} set.
	 */
	public XmlMarshallerView(Marshaller marshaller) {
		Assert.notNull(marshaller, "'marshaller' must not be null");
		setContentType(DEFAULT_CONTENT_TYPE);
		this.marshaller = marshaller;
		setExposePathVariables(false);
	}

	public void setJibxMarshallerFactory(JibxMarshallerFactory jibxMarshallerFactory) {
		this.jibxMarshallerFactory = jibxMarshallerFactory;
	}

	/**
	 * Sets the {@link Marshaller} to be used by this view.
	 */
	public void setMarshaller(Marshaller marshaller) {
		Assert.notNull(marshaller, "'marshaller' must not be null");
		this.marshaller = marshaller;
	}

	/**
	 * Set the name of the model key that represents the object to be marshalled. If not specified, the model map will be
	 * searched for a supported value type.
	 *
	 * @see Marshaller#supports(Class)
	 */
	public void setModelKey(String modelKey) {
		this.modelKey = modelKey;
	}

	@Override
	protected void initApplicationContext() throws BeansException {
		if (marshaller == null && jibxMarshallerFactory == null) {
			throw new RuntimeException("Property 'marshaller' or 'jibxMarshallerFactory', at least one is required");
		}
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
										   HttpServletRequest request,
										   HttpServletResponse response) throws Exception {
		Object toBeMarshalled = locateToBeMarshalled(model);
		
		if (toBeMarshalled == null) {
			throw new ServletException("Unable to locate object to be marshalled in model: " + model);
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
		marshaller.marshal(toBeMarshalled, new StreamResult(bos));

		setResponseContentType(request, response);
		response.setContentLength(bos.size());

		FileCopyUtils.copy(bos.toByteArray(), response.getOutputStream());
	}

	/**
	 * Locates the object to be marshalled. The default implementation first attempts to look under the configured
	 * {@linkplain #setModelKey(String) model key}, if any, before attempting to locate an object of {@linkplain
	 * Marshaller#supports(Class) supported type}.
	 *
	 * @param model the model Map
	 * @return the Object to be marshalled (or {@code null} if none found)
	 * @throws ServletException if the model object specified by the {@linkplain #setModelKey(String) model key} is not
	 *                          supported by the marshaller
	 * @see #setModelKey(String)
	 */
	protected Object locateToBeMarshalled(Map<String, Object> model) throws ServletException {
		if (this.modelKey != null) {
			Object o = model.get(this.modelKey);
			if (o == null) {
				throw new ServletException("Model contains no object with key [" + modelKey + "]");
			}
			checkMarshaller(o);
			if (!this.marshaller.supports(o.getClass())) {
				throw new ServletException("Model object [" + o + "] retrieved via key [" + modelKey +
						"] is not supported by the Marshaller");
			}
			return o;
		}
		for (Object o : model.values()) {
			if (o != null) {
				checkMarshaller(o);
				if (this.marshaller.supports(o.getClass())) {
					return o;
				}
			}
		}
		return null;
	}
	
	/**
	 * 运行时获取Marshaller。
	 * @param object 要被序列化的对象
	 * @author yinlei
	 * date 2013-9-18 下午8:22:30
	 */
	protected void checkMarshaller(Object object) {
		if (marshaller == null || !marshaller.supports(object.getClass())) {
			marshaller = jibxMarshallerFactory.getJibxMarshaller(object.getClass());
		}
		if (marshaller == null) {
			throw new BasicException("XML视图解析器没有找到Marshaller。");
		}
	}
	
}
