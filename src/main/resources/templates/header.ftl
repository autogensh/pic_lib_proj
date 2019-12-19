<div class="header-wrapper">
  <!-- Header -->
  <header class="header navbar-fixed-top" id="header">
    <div class="container">
      <div class="header-section">
        <div class="header-wrap">
          <div class="header-col col-logo">
            <div class="logo">
              <a href="/">
                <img alt="" class="site-logo" src="/DIMENSIVA_logo.svg">
              </a>
            </div>
          </div>
          <div class="header-col col-nav">
            <nav id="nav">
              <div class="meniucentrat">
                <div class="menu-dan-container">
                  <ul class="menu" id="menu-dan">
                    <#list categories as c >
                      <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-998"
                          id="menu-item-998"><a href="/category/${c.id}">${c.name}</a></li>
                    </#list>
                  </ul>
                </div>
              </div>

              <ul class="shop-nav">
                <li id="x" style="cursor: pointer;"><i class="iconfont icon-cauta" style="color:black"></i></li>
                <li><a href="/about">ABOUT</a></li>
                <li><a href="/pricing">PRICING <font color="red">PRO</font></a></li>
                <li><a href="/log-in/">Login</a></li>
                <li>
                  <a class="loginul" href="/register/">Join</a></li>
              </ul>
            </nav>
          </div>

          <div class="header-col col-shop" style="display: none;">
          </div>
        </div>
        <div class="nav-toggle" style="display: none;">
          <span></span>
          <span></span>
          <span></span>
        </div>
        <!-- mobile navigation -->
        <div class="section-first colored-section" data-speed="4" data-type="background"
             id="y" style="display:none;padding:0px;margin-bottom: -10px;">
          <div class="product-search">
            <div class="product-search-form">
              <form action="https://dimensiva.com" method="GET">
              <div class="search-fields">
                <input name="s" placeholder="Search a 3d model and then hit enter" type="text" value="">
                <input name="post_type" type="hidden" value="download">
                <span class="search-btn" style="display:none"><input type="submit"></span>
              </div>
              </form>
            </div>
            <span class="clearfix"></span>
          </div>
        </div>
        <div class="mob-nav">
        </div>
      </div>
    </div>
  </header>
  <!-- Header End -->

  <!-- Search -->
</div>
