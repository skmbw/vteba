package com.vteba;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.jboss.marshalling.ByteBufferInput;
import org.jboss.marshalling.ByteBufferOutput;
import org.jboss.marshalling.ByteInput;
import org.jboss.marshalling.ByteOutput;
import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.vteba.user.model.User;
import com.vteba.utils.serialize.Kryos;
import com.vteba.utils.serialize.Protos;

public class Test {

	public static void main(String[] args) {
		//System.out.println(6+6+8+"66" +7+7);
		Schema<User> schema = RuntimeSchema.getSchema(User.class);
		long d = System.currentTimeMillis();
		LinkedBuffer buffer = LinkedBuffer.allocate(2048);
		
		User message = new User();
		message.setAddress("hao");
		message.setTelphone("13434348989");
		byte[] bytes = Protos.toByteArray(message);
		
		User user = new User();
		Protos.mergeFrom(bytes, user);
		System.out.println(System.currentTimeMillis() - d);
		
		d = System.currentTimeMillis();
		bytes = Kryos.toBytes(message);
		Kryos.fromBytes(bytes, User.class);
		System.out.println(System.currentTimeMillis() - d);
		
		d = System.currentTimeMillis();
		
		MarshallerFactory factory = Marshalling.getProvidedMarshallerFactory("serial");
		MarshallingConfiguration configuration = new MarshallingConfiguration();
		configuration.setVersion(5);
		try {
			Marshaller marshaller = factory.createMarshaller(configuration);
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			ByteOutput byteOutput = new ByteBufferOutput(byteBuffer);
			
			marshaller.start(byteOutput);
			marshaller.writeObject(message);
			marshaller.finish();
			marshaller.flush();
			
			Unmarshaller unmarshaller = factory.createUnmarshaller(configuration);
			
			
			ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
//			byteBuffer2.put(byteBuffer);
			ByteInput newInput = new ByteBufferInput(byteBuffer2);
			
			unmarshaller.read(byteBuffer.array());
			unmarshaller.start(newInput);
			unmarshaller.finish();
			User unUser = unmarshaller.readObject(User.class);
			System.out.println(unUser);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(System.currentTimeMillis() - d);
		
	}

}
