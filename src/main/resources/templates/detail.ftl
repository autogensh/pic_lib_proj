<!DOCTYPE html>
<html lang="cn">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="content-language" content="zh-CN">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link id="gsFavicon" rel="icon" href="/ic_suspendy_16x16.png" />
  <link href="/css/frontend-grid.css" rel="stylesheet">
  <link href="/css/style.css" rel="stylesheet">
  <title>${info.materialName} - 图库网</title>
</head>
<body>
<div class="page">
  <#include "header.ftl" />
  <div class="section">
    <div class="container">
      <div class="row" style="padding:0 25px;margin:0 auto;">
        <div class="col-lg-7 col-md-5">
          <div class="paper">
            <div class="preview-area">
              <div itemprop="image" class="preview-image">

                <!--  Post Image Gallery  -->
                <ul class="banner-slider2">
                  <li>
                    <img width="1024" height="1024" src="${(info.coverImg!'/images/blank.jpg')?replace('.orin.', '.1024x1024.')}" class="attachment-large size-large wp-post-image" alt=""
                         srcset="${(info.coverImg!'/images/blank.jpg')?replace('.orin.', '.1024x1024.')} 1024w, ${(info.coverImg!'/images/blank.jpg')?replace('.orin.', '.800x800.')} 800w, ${(info.coverImg!'/images/blank.jpg')?replace('.orin.', '.300x300.')} 300w, ${(info.coverImg!'/images/blank.jpg')?replace('.orin.', '.768x768.')} 768w, ${(info.coverImg!'/images/blank.jpg')?replace('.orin.', '.170x170.')} 170w, ${(info.coverImg!'/images/blank.jpg')?replace('.orin.', '.1000x1000.')} 1000w, ${(info.coverImg!'/images/blank.jpg')?replace('.orin.', '.1280x1280.')} 1280w" sizes="(max-width: 1024px) 100vw, 1024px">
                  </li>
                </ul>

              </div>

            </div>
            <div class="content-area">
            </div>
          </div>
        </div>


        <div class="col-lg-4 col-md-4">
          <div class="sidebar">


            <h2 itemprop="name">${info.materialName}</h2>

            <div class="page_subtitle">PRO </div>    <div class="sidebar-item">			<div class="textwidget"></div>
          </div>   <hr>
            <div itemprop="alternativeHeadline">
              <p>${info.desc}</p>
              <hr><a href="/pricing"><div class="le-buton1"> REGISTER<i class="unlock"></i> </div></a>
              <br>类目: <a href="/category/${info.catId}" rel="cat">${info.categoryName}</a>
              <br>标签: <a href="#" rel="tag">${info.tags!''}</a>
              <br>上传人: ${info.owner}
              <br>上传时间: ${info.createAt?string('yyyy年MM月dd日 HH:mm:ss')}
              <br>浏览数: ${info.views}
              <br>下载数: ${info.downs}
              <hr>
            </div>
            <ul class="tab">
              <li><a href="javascript:void(0)" class="tablinks active" onclick="openCity(event, 'File')" id="defaultOpen"><i class="iconfont icon-file"></i><br><b>文件</b></a></li>
              <li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'Dimensions')"><i class="iconfont icon-description"></i><br><b>尺寸</b></a></li>
            </ul>

            <div id="File" class="tabcontent" style="display: block;">
              <div class="product-author">   <b>文件大小: </b>&nbsp;${info.fileSize}</div>
              <div itemprop="fileFormat" class="product-author">   <b>文件格式: </b>&nbsp;${info.fileFormat}  </div>
              <div class="product-author">   <b>授权许可: </b>&nbsp;${info.licenseTitle} </div>
              <div class="product-author">   <b>浏览数: </b>&nbsp;${info.views} </div>
              <div class="product-author">   <b>下载数: </b>&nbsp;${info.downs} </div>
            </div>
            <div id="Dimensions" class="tabcontent" style="display: none;">
              <div class="product-author">   <b>色彩空间:&nbsp;</b> ${info.colorSpace} </div>
              <div class="product-author">   <b>尺寸/像素:&nbsp;</b> ${info.measure} </div>
            </div>
          </div>

<!--          <hr>-->
<!--          这里插入广告(如果有的话)-->
<!--          <script async="" src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>-->
<!--          &lt;!&ndash; Sidebar ad 2 &ndash;&gt;-->
<!--          <ins class="adsbygoogle" style="display:inline-block;width:336px;height:280px" data-ad-client="ca-pub-2214499964440034" data-ad-slot="7177280703" data-adsbygoogle-status="done"><ins id="aswift_0_expand" style="display:inline-table;border:none;height:280px;margin:0;padding:0;position:relative;visibility:visible;width:336px;background-color:transparent;"><ins id="aswift_0_anchor" style="display:block;border:none;height:280px;margin:0;padding:0;position:relative;visibility:visible;width:336px;background-color:transparent;"><iframe width="336" height="280" frameborder="0" marginwidth="0" marginheight="0" vspace="0" hspace="0" allowtransparency="true" scrolling="no" allowfullscreen="true" onload="var i=this.id,s=window.google_iframe_oncopy,H=s&amp;&amp;s.handlers,h=H&amp;&amp;H[i],w=this.contentWindow,d;try{d=w.document}catch(e){}if(h&amp;&amp;d&amp;&amp;(!d.body||!d.body.firstChild)){if(h.call){setTimeout(h,0)}else if(h.match){try{h=s.upd(h,i)}catch(e){}w.location.replace(h)}}" id="aswift_0" name="aswift_0" style="left:0;position:absolute;top:0;border:0px;width:336px;height:280px;"></iframe></ins></ins></ins>-->
<!--          <script>-->
<!--              (adsbygoogle = window.adsbygoogle || []).push({});-->
<!--          </script>-->
        </div>



      </div>
    </div>
  </div>
  <#include "footer.ftl" />
</div>
<script>
    function openCity(evt, cityName) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(cityName).style.display = "block";
        evt.currentTarget.className += " active";

    }
    document.getElementById("defaultOpen").click();
</script>
</body>
</html>
