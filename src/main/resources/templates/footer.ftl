<footer class="" id="footer">
  <div class="container">
    <div class="footer-widget">
      <div class="textwidget">
        <p><img alt="dimensiva" src="/logo-jos.png" width="120px"></p>
        <p><a href="/about">About us</a></p>
        <p><a href="/contact">Contact us</a></p>
        <p><a href="/user-terms">User Terms</a></p>
        <p><a href="/private-policy">Private Policy</a></p>
        <p><a href="/license">License</a></p>
      </div>
    </div>
    <div class="widget_text footer-widget"><h2 class="widgettitle">RECENT 3D MODELS</h2>
      <div class="textwidget custom-html-widget"><p style="padding-top:1px;">
      </p>
        <div class="edd_downloads_list edd_download_columns_2">

          <#list footerMaterials as m>
            <#if m_index == 8>
              <#break>
            </#if>
          <div class="edd_download" id="edd_download_${m.id}">

            <div class="edd_download_inner">

              <div class="edd_download_image thumb">
                <a href="/detail/${m.id}"
                   title="${m.materialName}">
                  <span><i class="demo-icons icon-link"></i></span>
                  <img alt="" class="attachment-thumbnail size-thumbnail wp-post-image"
                       height="300"
                       sizes="(max-width: 300px) 100vw, 300px"
                       src="${(m.coverImg)!'/images/blank.jpg'}"
                       srcset="${(m.coverImg!'/images/blank.jpg')?replace('.orin.', '.300x300.')} 300w, ${(m.coverImg!'/images/blank.jpg')?replace('.orin.', '.800x800.')} 800w, ${(m.coverImg!'/images/blank.jpg')?replace('.orin.', '.1024x1024.')} 1024w, ${(m.coverImg!'/images/blank.jpg')?replace('.orin.', '.768x768.')} 768w, ${(m.coverImg!'/images/blank.jpg')?replace('.orin.', '.170x170.')} 170w, ${(m.coverImg!'/images/blank.jpg')?replace('.orin.', '.1000x1000.')} 1000w, ${(m.coverImg!'/images/blank.jpg')?replace('.orin.', '.1280x1280.')} 1280w"
                       width="300"> </a>
              </div>
              <div class="product-details">
                <div class="product-author" style="float:left;color:red;padding-right: 1px;">PRO</div>
                <div class="product-name" style="width:185px;text-align:center;float: left;"><span><a
                            href="/detail/${m.id}">${m.materialName}</a></span>
                </div>
                <div class="product-options" style="width:25px;float: left;font-size: 22px;">
                  <a href="/pricing"> <i class="download"></i></a></div>
              </div>
              <div class="edd_download_excerpt hidden" itemprop="description">
                <p>${m.desc}</p>
              </div>
              <div class="edd_download_buy_button">
                <form class="edd_download_purchase_form" id="edd_purchase_${m.id}">
                <div class="edd_free_downloads_form_class"><a
                  class="edd-add-to-cart button white edd-submit edd-free-download edd-free-download-single edd-has-js"
                  data-download-id="${m.id}" href="#edd-free-download-modal">&nbsp;</a></div>
                </form>
              </div>  <!-- item .details close -->
            </div>
          </div>
          </#list>
        </div>

        <div class="edd_pagination navigation" id="edd_download_pagination">
          <span aria-current="page" class="page-numbers current">1</span>
          <a class="page-numbers" href="https://dimensiva.com/page/2/">2</a>
          <a class="page-numbers" href="https://dimensiva.com/page/3/">3</a>
          <span class="page-numbers dots">…</span>
          <a class="page-numbers" href="https://dimensiva.com/page/76/">76</a>
          <a class="next page-numbers" href="https://dimensiva.com/page/2/">Next »</a></div>
        <p></p></div>
    </div>
    <ul class="footer-social social-icons">
    </ul>
    <div class="footer-text">© Dimensiva 2014 - 2019 All Rights reserved. Trademarks and brands are the property of
      their respective owners.<br><a href="https://media90.ro/" style="color: transparent !important; font-size:10px"
                                     target="_blank">creare site</a></div>
  </div>
</footer>
