<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="inc/header.jsp"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort();
%>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- Head BEGIN -->
<head>
  <meta charset="utf-8">
  <title>微特吧</title>

  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <meta content="Metronic Shop UI description" name="description">
  <meta content="Metronic Shop UI keywords" name="keywords">
  <meta content="keenthemes" name="author">

  <meta property="og:site_name" content="-CUSTOMER VALUE-">
  <meta property="og:title" content="-CUSTOMER VALUE-">
  <meta property="og:description" content="-CUSTOMER VALUE-">
  <meta property="og:type" content="website">
  <meta property="og:image" content="-CUSTOMER VALUE-"><!-- link to image for socio -->
  <meta property="og:url" content="-CUSTOMER VALUE-">

  <link rel="shortcut icon" href="favicon.ico">
  <link href="/favicon.ico" rel="SHORTCUT ICON" type="image/ico">

  <!-- Global styles START -->          
  <link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="assets/plugins/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
  <!-- Global styles END --> 
   
  <!-- Page level plugin styles START -->
  <link href="assets/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">              
  <link href="assets/plugins/bxslider/jquery.bxslider.css" rel="stylesheet">
  <link rel="stylesheet" href="assets/plugins/layerslider/css/layerslider.css" type="text/css">
  <!-- Page level plugin styles END -->

  <!-- Theme styles START -->
  <link href="assets/css/style-metronic.css" rel="stylesheet" type="text/css">
  <link href="assets/css/style.css" rel="stylesheet" type="text/css">
  <link href="assets/css/style-responsive.css" rel="stylesheet" type="text/css">  
  <link href="assets/css/custom.css" rel="stylesheet" type="text/css">
  <!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body>
    <!-- BEGIN TOP BAR -->
    <div class="pre-header">
        <div class="container">
            <div class="row">
                <!-- BEGIN TOP BAR LEFT PART -->
                <div class="col-md-6 col-sm-6 additional-shop-info">
                    <ul class="list-unstyled list-inline">
                        <li><i class="fa fa-phone"></i><span>18667007290</span></li>
                        <!-- BEGIN CURRENCIES -->
                        <li class="shop-currencies">
                            <a href="javascript:void(0);">€</a>
                            <a href="javascript:void(0);">£</a>
                            <a href="javascript:void(0);" class="current">$</a>
                        </li>
                        <!-- END CURRENCIES -->
                        <!-- BEGIN LANGS -->
                        <li class="langs-block">
                            <a href="javascript:void(0);" class="current">简体中文 <i class="fa fa-angle-down"></i></a>
                            <div class="langs-block-others-wrapper"><div class="langs-block-others">
                              <a href="javascript:void(0);">English</a>
                              <a href="javascript:void(0);">繁體中文</a>
                              <a href="javascript:void(0);">French</a>
                            </div></div>
                        </li>
                        <!-- END LANGS -->
                    </ul>
                </div>
                <!-- END TOP BAR LEFT PART -->
                <!-- BEGIN TOP BAR MENU -->
                <div class="col-md-6 col-sm-6 additional-nav">
                    <ul class="list-unstyled list-inline pull-right">
                        <li><a href="#">我的账户</a></li>
                        <li><a href="#">我的愿望清单</a></li>
                        <li><a href="checkout.html">去结算</a></li>
                        <li><a href="/user/login">去登录</a></li>
                    </ul>
                </div>
                <!-- END TOP BAR MENU -->
            </div>
        </div>        
    </div>
    <!-- END TOP BAR -->

    <!-- BEGIN HEADER -->
    <div role="navigation" class="navbar header no-margin">
        <div class="container">
            <div class="navbar-header">
                <!-- BEGIN RESPONSIVE MENU TOGGLER -->
                <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- END RESPONSIVE MENU TOGGLER -->
                <a href="index.html" class="navbar-brand"><img src="assets/img/logo_red.png" alt="Metronic Shop UI"></a><!-- LOGO -->
            </div>
            <!-- BEGIN CART -->
            <div class="cart-block">
                <div class="cart-info">
                    <a href="javascript:void(0);" class="cart-info-count">共 3 件商品</a>
                    <a href="javascript:void(0);" class="cart-info-value">￥1260</a>
                </div>
                <i class="fa fa-shopping-cart"></i>
                <!-- BEGIN CART CONTENT -->
                <div class="cart-content-wrapper">
                  <div class="cart-content">
                    <ul class="scroller" style="height: 250px;">
                      <li>
                        <a href="item.html"><img src="assets/temp/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                        <span class="cart-content-count">x 1</span>
                        <strong><a href="item.html">Rolex Classic Watch</a></strong>
                        <em>$1230</em>
                        <a href="javascript:void(0);" class="del-goods"><i class="fa fa-times"></i></a>
                      </li>
                      <li>
                       <a href="item.html"><img src="assets/temp/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                        <span class="cart-content-count">x 1</span>
                        <strong><a href="item.html">Rolex Classic Watch</a></strong>
                        <em>$1230</em>
                        <a href="javascript:void(0);" class="del-goods"><i class="fa fa-times"></i></a>
                      </li>
                      <li>
                        <a href="item.html"><img src="assets/temp/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                        <span class="cart-content-count">x 1</span>
                        <strong><a href="item.html">Rolex Classic Watch</a></strong>
                        <em>$1230</em>
                        <a href="javascript:void(0);" class="del-goods"><i class="fa fa-times"></i></a>
                      </li>
                      <li>
                        <a href="item.html"><img src="assets/temp/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                        <span class="cart-content-count">x 1</span>
                        <strong><a href="item.html">Rolex Classic Watch</a></strong>
                        <em>$1230</em>
                        <a href="javascript:void(0);" class="del-goods"><i class="fa fa-times"></i></a>
                      </li>
                      <li>
                        <a href="item.html"><img src="assets/temp/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                        <span class="cart-content-count">x 1</span>
                        <strong><a href="item.html">Rolex Classic Watch</a></strong>
                        <em>$1230</em>
                        <a href="javascript:void(0);" class="del-goods"><i class="fa fa-times"></i></a>
                      </li>
                      <li>
                       <a href="item.html"><img src="assets/temp/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                        <span class="cart-content-count">x 1</span>
                        <strong><a href="item.html">Rolex Classic Watch</a></strong>
                        <em>$1230</em>
                        <a href="javascript:void(0);" class="del-goods"><i class="fa fa-times"></i></a>
                      </li>
                      <li>
                        <a href="item.html"><img src="assets/temp/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                        <span class="cart-content-count">x 1</span>
                        <strong><a href="item.html">Rolex Classic Watch</a></strong>
                        <em>$1230</em>
                        <a href="javascript:void(0);" class="del-goods"><i class="fa fa-times"></i></a>
                      </li>
                      <li>
                        <a href="item.html"><img src="assets/temp/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                        <span class="cart-content-count">x 1</span>
                        <strong><a href="item.html">Rolex Classic Watch</a></strong>
                        <em>$1230</em>
                        <a href="javascript:void(0);" class="del-goods"><i class="fa fa-times"></i></a>
                      </li>
                    </ul>
                    <div class="text-right">
                      <a href="shopping-cart.html" class="btn btn-default">查看购物车</a>
                      <a href="checkout.html" class="btn btn-primary">结算</a>
                    </div>
                  </div>
                </div>
                <!-- END CART CONTENT -->
            </div>
            <!-- END CART -->
            <!-- BEGIN NAVIGATION -->
            <div class="collapse navbar-collapse mega-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                      <a class="dropdown-toggle" data-toggle="dropdown" data-delay="0" data-close-others="false" data-target="product-list.html" href="product-list.html">
                        女士 
                        <i class="fa fa-angle-down"></i>
                      </a>
                      <!-- BEGIN DROPDOWN MENU -->
                      <ul class="dropdown-menu" aria-labelledby="mega-menu">
                        <li>
                          <div class="nav-content">
                            <!-- BEGIN DROPDOWN MENU - COLUMN -->
                            <div class="nav-content-col">
                              <h3>Footwear</h3>
                              <ul>
                                <li><a href="product-list.html">Astro Trainers</a></li>
                                <li><a href="product-list.html">Basketball Shoes</a></li>
                                <li><a href="product-list.html">Boots</a></li>
                                <li><a href="product-list.html">Canvas Shoes</a></li>
                                <li><a href="product-list.html">Football Boots</a></li>
                                <li><a href="product-list.html">Golf Shoes</a></li>
                                <li><a href="product-list.html">Hi Tops</a></li>
                                <li><a href="product-list.html">Indoor and Court Trainers</a></li>
                              </ul>
                            </div>
                            <!-- END DROPDOWN MENU - COLUMN -->
                            <!-- BEGIN DROPDOWN MENU - COLUMN -->
                            <div class="nav-content-col">
                              <h3>Clothing</h3>
                              <ul>
                                <li><a href="product-list.html">Base Layer</a></li>
                                <li><a href="product-list.html">Character</a></li>
                                <li><a href="product-list.html">Chinos</a></li>
                                <li><a href="product-list.html">Combats</a></li>
                                <li><a href="product-list.html">Cricket Clothing</a></li>
                                <li><a href="product-list.html">Fleeces</a></li>
                                <li><a href="product-list.html">Gilets</a></li>
                                <li><a href="product-list.html">Golf Tops</a></li>
                              </ul>
                            </div>
                            <!-- END DROPDOWN MENU - COLUMN -->
                            <!-- BEGIN DROPDOWN MENU - COLUMN -->
                            <div class="nav-content-col">
                              <h3>Accessories</h3>
                              <ul>
                                <li><a href="product-list.html">Belts</a></li>
                                <li><a href="product-list.html">Caps</a></li>
                                <li><a href="product-list.html">Gloves, Hats and Scarves</a></li>
                              </ul>

                              <h3>Clearance</h3>
                              <ul>
                                <li><a href="product-list.html">Jackets</a></li>
                                <li><a href="product-list.html">Bottoms</a></li>
                              </ul>
                            </div>
                            <!-- END DROPDOWN MENU - COLUMN -->
                            <!-- BEGIN DROPDOWN MENU - BRANDS -->
                            <div class="nav-brands">
                              <ul>
                                <li><a href="product-list.html"><img title="esprit" alt="esprit" src="assets/temp/brands/esprit.jpg"></a></li>
                                <li><a href="product-list.html"><img title="gap" alt="gap" src="assets/temp/brands/gap.jpg"></a></li>
                                <li><a href="product-list.html"><img title="next" alt="next" src="assets/temp/brands/next.jpg"></a></li>
                                <li><a href="product-list.html"><img title="puma" alt="puma" src="assets/temp/brands/puma.jpg"></a></li>
                                <li><a href="product-list.html"><img title="zara" alt="zara" src="assets/temp/brands/zara.jpg"></a></li>
                              </ul>
                            </div>
                            <!-- END DROPDOWN MENU - BRANDS -->
                          </div>
                        </li>
                      </ul>
                      <!-- END DROPDOWN MENU -->
                    </li>
                    <li><a href="product-list.html">男士</a></li>
                    <li class="dropdown">
                      <a class="dropdown-toggle" data-toggle="dropdown" data-delay="0" data-close-others="false" data-target="product-list.html" href="product-list.html">
                        儿童
                        <i class="fa fa-angle-down"></i>
                      </a>
                      <!-- BEGIN DROPDOWN MENU -->
                      <ul class="dropdown-menu">
                        <li class="dropdown-submenu">
                          <a href="product-list.html">Hi Tops <i class="fa fa-angle-right"></i></a>
                          <ul class="dropdown-menu">
                            <li><a href="product-list.html">Second Level Link</a></li>
                            <li><a href="product-list.html">Second Level Link</a></li>
                            <li class="dropdown-submenu">
                              <a href="product-list.html">Second Level Link <i class="fa fa-angle-right"></i></a>
                              <ul class="dropdown-menu">
                                <li><a href="product-list.html">Third Level Link</a></li>
                                <li><a href="product-list.html">Third Level Link</a></li>
                                <li><a href="product-list.html">Third Level Link</a></li>
                              </ul>
                            </li>
                          </ul>
                        </li>
                        <li><a href="product-list.html">Running Shoes</a></li>
                        <li><a href="product-list.html">Jackets and Coats</a></li>
                        <li><a href="product-list.html">Tennis Clothing</a></li>
                        <li class="dropdown-submenu">
                          <a href="product-list.html">Running Clothing <i class="fa fa-angle-right"></i></a>
                          <ul class="dropdown-menu">
                            <li><a href="product-list.html">Second Level Link</a></li>
                            <li><a href="product-list.html">Second Level Link</a></li>
                            <li class="dropdown-submenu">
                              <a href="product-list.html">Second Level Link <i class="fa fa-angle-right"></i></a>
                              <ul class="dropdown-menu">
                                <li><a href="product-list.html">Third Level Link</a></li>
                                <li><a href="product-list.html">Third Level Link</a></li>
                                <li><a href="product-list.html">Third Level Link</a></li>
                              </ul>
                            </li>
                          </ul>
                        </li>
                      </ul>
                      <!-- END DROPDOWN MENU -->
                    </li>
                    <li class="dropdown">
                      <a class="dropdown-toggle" data-toggle="dropdown" data-delay="0" data-close-others="false" data-target="product-list.html" href="product-list.html">
                        新品推荐 
                        <i class="fa fa-angle-down"></i>
                      </a>
                      <!-- BEGIN DROPDOWN MENU -->
                      <ul class="dropdown-menu" aria-labelledby="mega-menu-catalogue">
                        <li>
                          <div class="nav-content">
                            <div class="product-item">
                              <div class="pi-img-wrapper">
                                <a href="item.html"><img src="assets/temp/products/model4.jpg" class="img-responsive" alt="Berry Lace Dress"></a>
                              </div>
                              <h3><a href="item.html">Berry Lace Dress</a></h3>
                              <div class="pi-price">$29.00</div>
                              <a href="#" class="btn btn-default add2cart">加入购物车</a>
                            </div>
                            <div class="product-item">
                              <div class="pi-img-wrapper">
                                <a href="item.html"><img src="assets/temp/products/model3.jpg" class="img-responsive" alt="Berry Lace Dress"></a>
                              </div>
                              <h3><a href="item.html">Berry Lace Dress</a></h3>
                              <div class="pi-price">$29.00</div>
                              <a href="#" class="btn btn-default add2cart">加入购物车</a>
                            </div>
                            <div class="product-item">
                              <div class="pi-img-wrapper">
                                <a href="item.html"><img src="assets/temp/products/model7.jpg" class="img-responsive" alt="Berry Lace Dress"></a>
                              </div>
                              <h3><a href="item.html">Berry Lace Dress</a></h3>
                              <div class="pi-price">$29.00</div>
                              <a href="#" class="btn btn-default add2cart">加入购物车</a>
                            </div>
                          </div>
                        </li>
                      </ul>
                      <!-- END DROPDOWN MENU -->
                    </li>
                    <li class="dropdown">
                      <a class="dropdown-toggle" data-toggle="dropdown" data-delay="0" data-close-others="false" data-target="#" href="#">
                        Pages
                        <i class="fa fa-angle-down"></i>
                      </a>
                      <!-- BEGIN DROPDOWN MENU -->
                      <ul class="dropdown-menu">
                        <li><a href="index-light-footer.html">Light Footer</a></li>
                        <li><a href="product-list.html">Product List</a></li>
                        <li><a href="search-result.html">Search Result</a></li>
                        <li><a href="item.html">Product Page</a></li>
                        <li><a href="shopping-cart-null.html">Shopping Cart (Null Cart)</a></li>
                        <li><a href="shopping-cart.html">Shopping Cart</a></li>
                        <li><a href="checkout.html">Checkout</a></li>
                        <li><a href="reg-page.html">Registration Page</a></li>
                        <li><a href="login-page.html">Login Page</a></li>
                        <li><a href="forgotton-password.html">Forget Password</a></li>
                        <li><a href="about.html">About</a></li>
                        <li><a href="contacts.html">Contacts</a></li>
                        <li><a href="faq.html">FAQ</a></li>
                        <li><a href="privacy-policy.html">Privacy Policy</a></li>
                        <li><a href="terms-conditions-page.html">Terms & Conditions</a></li>
                        <li><a href="site-map.html">Site Map</a></li>
                        <li><a href="page-404.html">404</a></li>
                        <li><a href="page-500.html">500</a></li> 
                      </ul>
                      <!-- END DROPDOWN MENU -->
                    </li>
                    <li class="dropdown">
                      <a class="dropdown-toggle" data-toggle="dropdown" data-delay="0" data-close-others="false" data-target="#" href="#">
                        Features
                        <i class="fa fa-angle-down"></i>
                      </a>
                      <!-- BEGIN DROPDOWN MENU -->
                      <ul class="dropdown-menu">
                        <li><a href="feature-typography.html">Typography</a></li>
                        <li><a href="feature-forms.html">Forms</a></li>
                        <li><a href="feature-buttons.html">Buttons</a></li>
                        <li><a href="feature-icons.html">Icons</a></li>
                      </ul>
                      <!-- END DROPDOWN MENU -->
                    </li>
                    <li><a href="http://keenthemes.com/preview/metronic_admin/ecommerce_index.html">Admin theme</a></li>
                    <!-- BEGIN TOP SEARCH -->
                    <li class="menu-search">
                        <span class="sep"></span>
                        <i class="fa fa-search search-btn"></i>
                        <div class="search-box">
                            <form action="#">
                                <div class="input-group">
                                    <input type="text" placeholder="Search" class="form-control">
                                    <span class="input-group-btn">
                                        <button class="btn btn-primary" type="submit">Search</button>
                                    </span>
                                </div>
                            </form>
                        </div> 
                    </li>
                    <!-- END TOP SEARCH -->
                </ul>
            </div>
            <!-- END NAVIGATION -->
        </div>
    </div>
    <!-- END HEADER -->

    <!-- BEGIN SLIDER -->
    <div class="page-slider margin-bottom-35">
      <!--LayerSlider begin-->
      <div id="layerslider" style="width: 100%; height: 494px; margin: 0 auto;">
          <!--LayerSlider layer-->
          <div class="ls-layer ls-layer1" style="slidedirection: right; transition2d: 24,25,27,28; ">
            <img src="assets/temp/sliders/slide1/bg.jpg" class="ls-bg" alt="Slide background">
            <div class="ls-s-1 title" style=" top: 96px; left: 35%; slidedirection : fade; slideoutdirection : fade; durationin : 750; durationout : 750; easingin : easeOutQuint; rotatein : 90; rotateout : -90; scalein : .5; scaleout : .5; showuntil : 4000; white-space: nowrap;">
              Tones of <strong>shop UI features</strong> designed
            </div>
            <div class="ls-s-1 mini-text" style=" top: 338px; left: 35%; slidedirection : fade; slideoutdirection : fade; durationout : 750; easingin : easeOutQuint; delayin : 300; showuntil : 4000; white-space: nowrap;">
              Lorem ipsum dolor sit amet  constectetuer diam<br > adipiscing elit euismod ut laoreet dolore.
            </div>
          </div>

          <!--LayerSlider layer-->
          <div class="ls-layer ls-layer2" style="slidedirection: right; transition2d: 110,111,112,113; ">
            <img src="assets/temp/sliders/slide2/bg.jpg" class="ls-bg" alt="Slide background">
            <div class="ls-s-1 ls-title title" style=" top: 40%; left: 21%; slidedirection : fade; slideoutdirection : fade; durationin : 750; durationout : 750; easingin : easeOutQuint; easingout : easeInOutQuint; delayin : 0; delayout : 0; rotatein : 90; rotateout : -90; scalein : .5; scaleout : .5; showuntil : 4000; white-space: nowrap;">
              <strong class="title">Unlimted</strong>
              Layout Options
              <em class="title">Fully Responsive</em>
            </div>

            <div class="ls-s-2 ls-price title" style=" top: 50%; left: 45%; slidedirection : fade; slideoutdirection : fade; durationout : 109750; easingin : easeOutQuint; delayin : 300; scalein : .8; scaleout : .8; showuntil : 4000; white-space: nowrap;">
              <b>from</b>
              <strong><span>$</span>25</strong>
            </div>

            <a href="#" class="ls-s-1 ls-more mini-text" style=" top: 72%; left: 21%; slidedirection : fade; slideoutdirection : fade; durationin : 750; durationout : 750; easingin : easeOutQuint; easingout : easeInOutQuint; delayin : 0; delayout : 0; rotatein : 90; rotateout : -90; scalein : .5; scaleout : .5; showuntil : 4000; display: inline-block; white-space: nowrap;">
              查看更多详情
            </a>
          </div>

          <!--LayerSlider layer-->
          <div class="ls-layer ls-layer3" style="slidedirection: right; transition2d: 92,93,105; ">
            <img src="assets/temp/sliders/slide3/bg.jpg" class="ls-bg" alt="Slide background">

            <div class="ls-s-1 ls-title" style=" top: 83px; left: 33%; slidedirection : fade; slideoutdirection : fade; durationin : 750; durationout : 750; easingin : easeOutQuint; rotatein : 90; rotateout : -90; scalein : .5; scaleout : .5; showuntil : 4000; white-space: nowrap;">
              Full Admin & Frontend
              <strong>eCommerce UI</strong>
              Is Ready For Your Project
            </div>

            <div class="ls-s-1" style=" top: 333px; left: 33%; slidedirection : fade; slideoutdirection : fade; durationout : 750; easingin : easeOutQuint; delayin : 300; scalein : .8; scaleout : .8; showuntil : 4000; white-space: nowrap; font-size: 20px; font: 20px 'Open Sans Light', sans-serif;">
              <a href="#" class="ls-buy">
                立即购买！
              </a>
              <div class="ls-price">
                <span>所有这些仅仅:</span>
                <strong>25<sup>￥</sup></strong>
              </div>
            </div>
          </div>

          <!--LayerSlider layer-->
          <div class="ls-layer ls-layer5" style="slidedirection: right; transition2d: 110,111,112,113; ">
            <img src="assets/temp/sliders/slide5/bg.jpg" class="ls-bg" alt="Slide background">

            <div class="ls-s-1 title" style=" top: 35%; left: 60%; slidedirection : fade; slideoutdirection : fade; durationin : 750; durationout : 750; easingin : easeOutQuint; rotatein : 90; rotateout : -90; scalein : .5; scaleout : .5; showuntil : 4000; white-space: nowrap;">
              The most<br>
              wanted bijouterie
            </div>

            <div class="ls-s-1 mini-text" style=" top: 70%; left: 60%; slidedirection : fade; slideoutdirection : fade; durationout : 750; easingin : easeOutQuint; delayin : 300; scalein : .8; scaleout : .8; showuntil : 4000; white-space: nowrap;">
              <span>Lorem ipsum and</span>
              <a href="#">立即购买</a>
            </div>
          </div>
      </div>
      <!--LayerSlider end-->
    </div>
    <!-- END SLIDER -->

    <div class="main">
      <div class="container">
        <!-- BEGIN SALE PRODUCT & NEW ARRIVALS -->
        <div class="row margin-bottom-40">
          <!-- BEGIN SALE PRODUCT -->
          <div class="col-md-12 sale-product">
            <h2>New Arrivals</h2>
            <div class="bxslider-wrapper">
              <ul class="bxslider" data-slides-phone="1" data-slides-tablet="2" data-slides-desktop="5" data-slide-margin="15">
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/model1.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/model1.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                    <div class="sticker sticker-sale"></div>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/model2.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/model2.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress2</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/model6.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/model6.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress2</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/model4.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/model4.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="#">Berry Lace Dress4</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                    <div class="sticker sticker-new"></div>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/model5.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/model5.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress5</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/model3.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/model3.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress3</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/model7.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/model7.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress3</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <!-- END SALE PRODUCT -->
        </div>
        <!-- END SALE PRODUCT & NEW ARRIVALS -->

        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40 ">
          <!-- BEGIN SIDEBAR -->
          <div class="sidebar col-md-3 col-sm-4">
            <ul class="list-group margin-bottom-25 sidebar-menu">
              <li class="list-group-item clearfix"><a href="product-list.html"><i class="fa fa-angle-right"></i> Ladies</a></li>
              <li class="list-group-item clearfix dropdown">
                <a href="javascript:void(0);">
                  <i class="fa fa-angle-right"></i>
                  Mens
                  <i class="fa fa-angle-down"></i>
                </a>
                <ul class="dropdown-menu">
                  <li class="list-group-item dropdown clearfix">
                    <a href="javascript:void(0);"><i class="fa fa-circle"></i> Shoes <i class="fa fa-angle-down"></i></a>
                      <ul class="dropdown-menu">
                        <li class="list-group-item dropdown clearfix">
                          <a href="javascript:void(0);"><i class="fa fa-circle"></i> Classic <i class="fa fa-angle-down"></i></a>
                          <ul class="dropdown-menu">
                            <li><a href="product-list.html"><i class="fa fa-circle"></i> Classic 1</a></li>
                            <li><a href="product-list.html"><i class="fa fa-circle"></i> Classic 2</a></li>
                          </ul>
                        </li>
                        <li class="list-group-item dropdown clearfix">
                          <a href="javascript:void(0);"><i class="fa fa-circle"></i> Sport  <i class="fa fa-angle-down"></i></a>
                          <ul class="dropdown-menu">
                            <li><a href="product-list.html"><i class="fa fa-circle"></i> Sport 1</a></li>
                            <li><a href="product-list.html"><i class="fa fa-circle"></i> Sport 2</a></li>
                          </ul>
                        </li>
                      </ul>
                  </li>
                  <li><a href="product-list.html"><i class="fa fa-circle"></i> Trainers</a></li>
                  <li><a href="product-list.html"><i class="fa fa-circle"></i> Jeans</a></li>
                  <li><a href="product-list.html"><i class="fa fa-circle"></i> Chinos</a></li>
                  <li><a href="product-list.html"><i class="fa fa-circle"></i> T-Shirts</a></li>
                </ul>
              </li>
              <li class="list-group-item clearfix"><a href="product-list.html"><i class="fa fa-angle-right"></i> Kids</a></li>
              <li class="list-group-item clearfix"><a href="product-list.html"><i class="fa fa-angle-right"></i> Accessories</a></li>
              <li class="list-group-item clearfix"><a href="product-list.html"><i class="fa fa-angle-right"></i> Sports</a></li>
              <li class="list-group-item clearfix"><a href="product-list.html"><i class="fa fa-angle-right"></i> Brands</a></li>
              <li class="list-group-item clearfix"><a href="product-list.html"><i class="fa fa-angle-right"></i> Electronics</a></li>
              <li class="list-group-item clearfix"><a href="product-list.html"><i class="fa fa-angle-right"></i> Home & Garden</a></li>
              <li class="list-group-item clearfix"><a href="product-list.html"><i class="fa fa-angle-right"></i> Custom Link</a></li>
            </ul>
          </div>
          <!-- END SIDEBAR -->
          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-8">
            <h2>美人生活馆</h2>
            <div class="bxslider-wrapper">
              <ul class="bxslider" data-slides-phone="1" data-slides-tablet="2" data-slides-desktop="3" data-slide-margin="15">
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/k1.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/k1.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                    <div class="sticker sticker-new"></div>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/k2.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/k2.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress2</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/k3.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/k3.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress3</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/k4.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/k4.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress4</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                    <div class="sticker sticker-sale"></div>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/k1.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/k1.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress5</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/k2.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/k2.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress6</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->

        <!-- BEGIN TWO PRODUCTS & PROMO -->
        <div class="row margin-bottom-35 ">
          <!-- BEGIN TWO PRODUCTS -->
          <div class="col-md-6 two-items-bottom-items">
            <h2>时尚潮流</h2>
            <div class="bxslider-wrapper">
              <ul class="bxslider" data-slides-phone="1" data-slides-tablet="2" data-slides-desktop="2" data-slide-margin="15">
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/k4.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/k4.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">蕾丝连衣裙</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/k2.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/k2.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">冬季必备装备</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/k3.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/k3.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/k1.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/k1.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/k4.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/k4.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
                <li>
                  <div class="product-item">
                    <div class="pi-img-wrapper">
                      <img src="assets/temp/products/k3.jpg" class="img-responsive" alt="Berry Lace Dress">
                      <div>
                        <a href="assets/temp/products/k3.jpg" class="btn btn-default fancybox-button">Zoom</a>
                        <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                      </div>
                    </div>
                    <h3><a href="item.html">Berry Lace Dress</a></h3>
                    <div class="pi-price">$29.00</div>
                    <a href="#" class="btn btn-default add2cart">加入购物车</a>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <!-- END TWO PRODUCTS -->
          <!-- BEGIN PROMO -->
          <div class="col-md-6">
            <div class="content-slider">
              <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                  <li data-target="#myCarousel" data-slide-to="1"></li>
                  <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                  <div class="item active">
                    <img src="assets/temp/index-sliders/slide1.jpg" class="img-responsive" alt="Berry Lace Dress">
                  </div>
                  <div class="item">
                    <img src="assets/temp/index-sliders/slide2.jpg" class="img-responsive" alt="Berry Lace Dress">
                  </div>
                  <div class="item">
                    <img src="assets/temp/index-sliders/slide3.jpg" class="img-responsive" alt="Berry Lace Dress">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- END PROMO -->
        </div>        
        <!-- END TWO PRODUCTS & PROMO -->
      </div>
    </div>

    <!-- BEGIN BRANDS -->
    <div class="brands">
      <div class="container">
        <div class="row">
          <div class="bxslider-wrapper">
            <ul class="bxslider" data-slides-phone="1" data-slides-tablet="3" data-slides-desktop="6" data-slide-margin="15">
              <li><a href="product-list.html"><img src="assets/temp/brands/canon.jpg" alt="canon" title="canon"></a></li>
              <li><a href="product-list.html"><img src="assets/temp/brands/esprit.jpg" alt="esprit" title="esprit"></a></li>
              <li><a href="product-list.html"><img src="assets/temp/brands/gap.jpg" alt="gap" title="gap"></a></li>
              <li><a href="product-list.html"><img src="assets/temp/brands/next.jpg" alt="next" title="next"></a></li>
              <li><a href="product-list.html"><img src="assets/temp/brands/puma.jpg" alt="puma" title="puma"></a></li>
              <li><a href="product-list.html"><img src="assets/temp/brands/zara.jpg" alt="zara" title="zara"></a></li>
              <li><a href="product-list.html"><img src="assets/temp/brands/canon.jpg" alt="canon" title="canon"></a></li>
              <li><a href="product-list.html"><img src="assets/temp/brands/esprit.jpg" alt="esprit" title="esprit"></a></li>
              <li><a href="product-list.html"><img src="assets/temp/brands/gap.jpg" alt="gap" title="gap"></a></li>
              <li><a href="product-list.html"><img src="assets/temp/brands/next.jpg" alt="next" title="next"></a></li>
              <li><a href="product-list.html"><img src="assets/temp/brands/puma.jpg" alt="puma" title="puma"></a></li>
              <li><a href="product-list.html"><img src="assets/temp/brands/zara.jpg" alt="zara" title="zara"></a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <!-- END BRANDS -->

    <!-- BEGIN STEPS -->
    <div class="steps3 steps3red">
      <div class="container">
        <div class="row">
          <div class="col-md-4 steps3-col">
            <i class="fa fa-truck"></i>
            <div>
              <h2>Free shipping</h2>
              <em>Express delivery withing 3 days</em>
            </div>
            <span>&nbsp;</span>
          </div>
          <div class="col-md-4 steps3-col">
            <i class="fa fa-gift"></i>
            <div>
              <h2>Daily Gifts</h2>
              <em>3 Gifts daily for lucky customers</em>
            </div>
            <span>&nbsp;</span>
          </div>
          <div class="col-md-4 steps3-col">
            <i class="fa fa-phone"></i>
            <div>
              <h2>477 505 8877</h2>
              <em>24/7 customer care available</em>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- END STEPS -->

    <!-- BEGIN PRE-FOOTER -->
    <div class="pre-footer">
      <div class="container">
        <div class="row">
          <!-- BEGIN BOTTOM ABOUT BLOCK -->
          <div class="col-md-3 col-sm-6 pre-footer-col">
            <h2>关于我们</h2>
            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam sit nonummy nibh euismod tincidunt ut laoreet dolore magna aliquarm erat sit volutpat. Nostrud exerci tation ullamcorper suscipit lobortis nisl aliquip  commodo consequat. </p>
            <p>Duis autem vel eum iriure dolor vulputate velit esse molestie at dolore.</p>
          </div>
          <!-- END BOTTOM ABOUT BLOCK -->
          <!-- BEGIN BOTTOM INFO BLOCK -->
          <div class="col-md-3 col-sm-6 pre-footer-col">
            <h2>Information</h2>
            <ul class="list-unstyled">
              <li><i class="fa fa-angle-right"></i> <a href="#">Delivery Information</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="#">Customer Service</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="#">Order Tracking</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="#">Shipping & Returns</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="contacts.html">Contact Us</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="#">Careers</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="#">Payment Methods</a></li>
            </ul>
          </div>
          <!-- END INFO BLOCK -->
          <!-- BEGIN TWITTER BLOCK --> 
          <div class="col-md-3 col-sm-6 pre-footer-col">
            <h2>Latest Tweets</h2>
            <dl class="dl-horizontal f-twitter">
              <dt><i class="fa fa-twitter"></i></dt>
              <dd>
                <a href="#">@keenthemes</a>
                Imperdiet condimentum diam dolor lorem sit consectetur adipiscing
                <span>3 min ago</span>
              </dd>
            </dl>                    
            <dl class="dl-horizontal f-twitter">
              <dt><i class="fa fa-twitter"></i></dt>
              <dd>
                <a href="#">@keenthemes</a>
                Imperdiet condimentum diam dolor lorem sit consectetur adipiscing
                <span>3 min ago</span>
              </dd>
            </dl> 
            <dl class="dl-horizontal f-twitter">
              <dt><i class="fa fa-twitter"></i></dt>
              <dd>
                <a href="#">@keenthemes</a>
                Imperdiet condimentum diam dolor lorem sit consectetur adipiscing
                <span>3 min ago</span>
              </dd>
            </dl>           
          </div>
          <!-- END TWITTER BLOCK -->
          <!-- BEGIN BOTTOM CONTACTS -->
          <div class="col-md-3 col-sm-6 pre-footer-col">
            <h2>联系我们</h2>
            <address class="margin-bottom-40">
              35, Lorem Lis Street, Park Ave<br>
              California, US<br>
              Phone: 300 323 3456<br>
              Fax: 300 323 1456<br>
              Email: <a href="mailto:info@metronic.com">info@metronic.com</a><br>
              Skype: <a href="skype:metronic">metronic</a>
            </address>
          </div>
          <!-- END BOTTOM CONTACTS -->
        </div>
        <hr>
        <div class="row">
          <!-- BEGIN SOCIAL ICONS -->
          <div class="col-md-6 col-sm-6">
            <ul class="social-icons">
              <li><a class="rss" data-original-title="rss" href="#"></a></li>
              <li><a class="facebook" data-original-title="facebook" href="#"></a></li>
              <li><a class="twitter" data-original-title="twitter" href="#"></a></li>
              <li><a class="googleplus" data-original-title="googleplus" href="#"></a></li>
              <li><a class="linkedin" data-original-title="linkedin" href="#"></a></li>
              <li><a class="youtube" data-original-title="youtube" href="#"></a></li>
              <li><a class="vimeo" data-original-title="vimeo" href="#"></a></li>
              <li><a class="skype" data-original-title="skype" href="#"></a></li>
            </ul>
          </div>
          <!-- END SOCIAL ICONS -->
          <!-- BEGIN NEWLETTER -->
          <div class="col-md-6 col-sm-6">
            <div class="pre-footer-subscribe-box pull-right">
              <h2>Newsletter</h2>
              <form action="#">
                <div class="input-group">
                  <input type="text" placeholder="youremail@mail.com" class="form-control">
                  <span class="input-group-btn">
                    <button class="btn btn-primary" type="submit">订阅我们</button>
                  </span>
                </div>
              </form>
            </div> 
          </div>
          <!-- END NEWLETTER -->
        </div>
      </div>
    </div>
    <!-- END PRE-FOOTER -->

    <!-- BEGIN FOOTER -->
    <div class="footer padding-top-15">
      <div class="container">
        <div class="row">
          <!-- BEGIN COPYRIGHT -->
          <div class="col-md-6 col-sm-6 padding-top-10">
            2014 © 微特吧版权所有，保留所有权利。 ALL Rights Reserved. 
          </div>
          <!-- END COPYRIGHT -->
          <!-- BEGIN PAYMENTS -->
          <div class="col-md-6 col-sm-6">
            <ul class="list-unstyled list-inline pull-right margin-bottom-15">
              <li><img src="assets/img/payments/western-union.jpg" alt="We accept Western Union" title="We accept Western Union"></li>
              <li><img src="assets/img/payments/american-express.jpg" alt="We accept American Express" title="We accept American Express"></li>
              <li><img src="assets/img/payments/MasterCard.jpg" alt="We accept MasterCard" title="We accept MasterCard"></li>
              <li><img src="assets/img/payments/PayPal.jpg" alt="We accept PayPal" title="We accept PayPal"></li>
              <li><img src="assets/img/payments/visa.jpg" alt="We accept Visa" title="We accept Visa"></li>
            </ul>
          </div>
          <!-- END PAYMENTS -->
        </div>
      </div>
    </div>
    <!-- END FOOTER -->

    <!-- BEGIN fast view of a product -->
    <div id="product-pop-up" style="display: none; width: 700px;">
            <div class="product-page product-pop-up">
              <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-3">
                  <div class="product-main-image">
                    <img src="assets/temp/products/model7.jpg" alt="Cool green dress with red bell" class="img-responsive">
                  </div>
                  <div class="product-other-images">
                    <a href="#" class="active"><img alt="Berry Lace Dress" src="assets/temp/products/model3.jpg"></a>
                    <a href="#"><img alt="Berry Lace Dress" src="assets/temp/products/model4.jpg"></a>
                    <a href="#"><img alt="Berry Lace Dress" src="assets/temp/products/model5.jpg"></a>
                  </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-9">
                  <h1>Cool green dress with red bell</h1>
                  <div class="price-availability-block clearfix">
                    <div class="price">
                      <strong><span>$</span>47.00</strong>
                      <em>$<span>62.00</span></em>
                    </div>
                    <div class="availability">
                      Availability: <strong>In Stock</strong>
                    </div>
                  </div>
                  <div class="description">
                    <p>Lorem ipsum dolor ut sit ame dolore  adipiscing elit, sed nonumy nibh sed euismod laoreet dolore magna aliquarm erat volutpat 
Nostrud duis molestie at dolore.</p>
                  </div>
                  <div class="product-page-options">
                    <div class="pull-left">
                      <label class="control-label">Size:</label>
                      <select class="form-control input-sm">
                        <option>L</option>
                        <option>M</option>
                        <option>XL</option>
                      </select>
                    </div>
                    <div class="pull-left">
                      <label class="control-label">Color:</label>
                      <select class="form-control input-sm">
                        <option>Red</option>
                        <option>Blue</option>
                        <option>Black</option>
                      </select>
                    </div>
                  </div>
                  <div class="product-page-cart">
                    <div class="product-quantity">
                        <input id="product-quantity" type="text" value="1" readonly name="product-quantity" class="form-control input-sm">
                    </div>
                    <button class="btn btn-primary" type="submit">加入购物车</button>
                    <button class="btn btn-default" type="submit">更多详情</button>
                  </div>
                </div>

                <div class="sticker sticker-sale"></div>
              </div>
            </div>
    </div>
    <!-- END fast view of a product -->

    <!-- Load javascripts at bottom, this will reduce page load time -->
    <!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
    <!--[if lt IE 9]>
    <script src="assets/plugins/respond.min.js"></script>  
    <![endif]-->  
    <script src="assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
    <script type="text/javascript" src="assets/plugins/back-to-top.js"></script>
    <script type="text/javascript" src="assets/plugins/jQuery-slimScroll/jquery.slimscroll.min.js"></script>
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script type="text/javascript" src="assets/plugins/fancybox/source/jquery.fancybox.pack.js"></script><!-- pop up -->
    <script type="text/javascript" src="assets/plugins/bxslider/jquery.bxslider.min.js"></script><!-- slider for products -->
    <script type="text/javascript" src='assets/plugins/zoom/jquery.zoom.min.js'></script><!-- product zoom -->
    <script src="assets/plugins/bootstrap-touchspin/bootstrap.touchspin.js" type="text/javascript"></script><!-- Quantity -->

    <!-- BEGIN LayerSlider -->
    <script src="assets/plugins/layerslider/jQuery/jquery-easing-1.3.js" type="text/javascript"></script>
    <script src="assets/plugins/layerslider/jQuery/jquery-transit-modified.js" type="text/javascript"></script>
    <script src="assets/plugins/layerslider/js/layerslider.transitions.js" type="text/javascript"></script>
    <script src="assets/plugins/layerslider/js/layerslider.kreaturamedia.jquery.js" type="text/javascript"></script>
    <!-- END LayerSlider -->

    <script type="text/javascript" src="assets/scripts/app.js"></script>
    <script type="text/javascript" src="assets/scripts/index.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            App.init();    
            App.initBxSlider();
            Index.initLayerSlider();
            App.initImageZoom();
            App.initTouchspin();
        });
    </script>
    <!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>