<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	
	<link rel="stylesheet" type="text/css" href="login/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="login/css/demo.css">
	<link rel="stylesheet" href="login/css/style.css">
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet" type="text/css">
	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
	<script type="text/javascript">
	function checkForm(){
		var id=document.getElementById("name").value;
		var password=document.getElementById("password").value;
		if(id==null||id==""){
			alert("用户名不能为空！");
			return false;
		}
		if(password==null||password==""){
			alert("登录密码不能为空！");
			return false;
		}
		return true;
	}
	
	function resetValue(){
		document.getElementById("name").value="";
		document.getElementById("password").value="";
	}
</script>
	
</head>
<body>
	<div class="htmleaf-container">
		
	<svg id="svg-source" height="0" version="1.1" xmlns="http://www.w3.org/2000/svg" style="position:absolute; margin-left: -100%" xmlns:xlink="http://www.w3.org/1999/xlink">
		<g id="close-icon">
			<path d="M0.014,1.778L1.79,0.001l30.196,30.221l-1.778,1.777L0.014,1.778z"/>
			<path d="M1.79,31.999l-1.776-1.777L30.208,0.001l1.778,1.777L1.79,31.999z"/>
		</g>
	</svg>
		
    <div id="js-show-modal" class="launch-button">点击登录
      <div class="launch-button__glare"></div>
    </div>
    <div id="js-modal-overlay" class="modal-overlay"></div>
    <div id="js-modal-holder" class="modal-holder">
      <div id="js-hint1" class="hint hint--1">play with the form<br>葫芦娃~<br>在线考试系统</div>
      <div id="js-hint2" class="hint hint--2">then hit<br> the close icon</div>
      <div id="js-effect" style="outline1: 1px solid red" class="effect">
        <div class="effect__burst">
          <svg viewBox="0 0 300 300" width="300" height="300" id="js-burst">
            <g id="Group" sketch:type="MSLayerGroup" transform="translate(2.000000, 2.000000)">
              <path d="M119.843557,132.665423 L142.438936,241.234321" stroke="#FC46AD" stroke-width="2" transform="translate(131.141247, 186.949872) rotate(9.000000) translate(-131.141247, -186.949872) "></path>
              <path d="M120.923275,136.327807 L194.055085,223.544529" stroke="#D0D202" stroke-width="2" transform="translate(157.489180, 179.936168) rotate(9.000000) translate(-157.489180, -179.936168) "></path>
              <path d="M110.892215,7.63766131 L143.724586,126.274355" stroke="#FFE217" stroke-width="2" transform="translate(127.308401, 66.956008) rotate(-165.000000) translate(-127.308401, -66.956008) "></path>
              <path d="M198.35904,105.458064 L161.773069,223.598866" stroke="#B8E986" stroke-width="3" transform="translate(180.066054, 164.528465) rotate(-74.000000) translate(-180.066054, -164.528465) ">          </path>
              <path d="M146.454121,53.5458334 L227.175148,153.69563" stroke="#D0D202" stroke-width="2" transform="translate(186.814634, 103.620732) rotate(-74.000000) translate(-186.814634, -103.620732) ">          </path>
              <path d="M94.4127006,27.0036828 L46.0682754,156.269505" stroke="#51CAD7" stroke-width="3" transform="translate(70.240488, 91.636594) rotate(-257.000000) translate(-70.240488, -91.636594) ">          </path>
              <path d="M29.3969741,113.63349 L113.205038,207.338224" stroke="#FC3F6B" stroke-width="2" transform="translate(71.301006, 160.485857) rotate(-257.000000) translate(-71.301006, -160.485857) ">          </path>
              <path d="M125.792,38.3112087 L198.92381,125.527931" stroke="#D0D202" stroke-width="2" transform="translate(162.357905, 81.919570) rotate(-104.000000) translate(-162.357905, -81.919570) ">          </path>
              <path d="M43.4006609,130.173225 L130.540432,224.973356" stroke="#FC46AD" stroke-width="2" transform="translate(86.970546, 177.573291) rotate(-278.000000) translate(-86.970546, -177.573291) ">          </path>
              <path d="M157.646537,8.08731537 L121.060566,126.228117" stroke="#B8E986" stroke-width="3" transform="translate(139.353552, 67.157716) rotate(-187.000000) translate(-139.353552, -67.157716) ">          </path>
              <path d="M139.340711,132.100895 L90.9962855,261.366717" stroke="#51CAD7" stroke-width="3" transform="translate(115.168498, 196.733806) rotate(-10.000000) translate(-115.168498, -196.733806) ">          </path>
              <path d="M136.22617,122.003677 L220.034234,215.708411" stroke="#FC3F6B" stroke-width="2" transform="translate(178.130202, 168.856044) rotate(-10.000000) translate(-178.130202, -168.856044) "></path>
            </g>
          </svg>
        </div>
        <div class="effect__circle">
          <svg viewBox="0 0 100 100" width="100" height="100">
            <circle cx="50" cy="50" fill="none" id="js-circle"></circle>
          </svg>
        </div>
        <div class="effect__line effect__line--1">
          <svg viewBox="0 0 4 900" width="4" height="900">
            <defs>
              <g id="proto-line" class="js-line">
                <line x1="2" x2="2" y1="0" y2="900" stroke="red" stroke-dasharray="900 1800" stroke-dashoffset="900"></line>
                <line x1="2" x2="2" y1="0" y2="900" stroke="red" stroke-dasharray="900 1800" stroke-dashoffset="900"></line>
                <line x1="2" x2="2" y1="0" y2="900" stroke="red" stroke-dasharray="900 1800" stroke-dashoffset="900"></line>
              </g>
            </defs>
            <use xlink:href="#proto-line" width="4" height="900"></use>
          </svg>
        </div>
        <div class="effect__line effect__line--2">
          <svg viewBox="0 0 4 900" width="4" height="900">
            <use xlink:href="#proto-line" width="4" height="900"></use>
          </svg>
        </div>
        <div class="effect__line effect__line--3">
          <svg viewBox="0 0 4 900" width="4" height="900">
            <use xlink:href="#proto-line" width="4" height="900"></use>
          </svg>
        </div>
        <div class="effect__line effect__line--4">
          <svg viewBox="0 0 4 900" width="4" height="900">
            <use xlink:href="#proto-line" width="4" height="900"></use>
          </svg>
        </div>
      </div>
      <form action="${pageContext.request.contextPath }/manage_login.action" method="post" onsubmit="return checkForm()" id="js-modal" class="modal">
        <div id="js-close-button" class="modal__close">
          <div id="" title="" class="icon ">
            <svg viewBox="0 0 32 32">
              <use xlink:href="#close-icon"></use>
            </svg>
          </div>
        </div>
        <div class="modal__header">Log In</div>
        <p>返回登录:<a href="index.jsp">biu~</a></p>
        <div class="modal__description">欢迎登录葫芦娃在线考试系统, click × to close it</div>
        <div class="modal__section">
            <div class="input-with-label">
              <input id="name" name="stuname" value="${manage.stuname }" type="text" class="input-with-label__input">
              <label for="name" class="input-with-label__label"> 用户名
                <div class="input-with-label__label__corner"></div>
              </label>
            </div>
        </div>
        <div class="modal__section">
            <div class="input-with-label">
              <input id="password"  name="mpassword" value="${manager.mpassword }" type="password" class="input-with-label__input">
              <label for="password" class="input-with-label__label">密码
                <div class="input-with-label__label__corner"></div>
              </label>
            </div>
        </div>
        <div class="modal__section grid grid--sliced grid--gutter-x2">
          <div class="grid-bit grid-bit--14-20">
            <button type="submit">log in</button>
          </div>
          <div class="grid-bit grid-bit--6-20">
            <button class="button--grey" type="button"  onclick="resetValue()">cancel</button>
          </div>
        </div>
      </form>
      <svg style="display:none">
        <image width="480" height="450" xlink:href="" id="proto-image" class="js-proto-image"></image>
      </svg>
      <div id="js-break-parts" class="break-parts">
        <div id="js-svg-overlay" class="svg-overlay">
          <svg viewBox="0 0 480 450" id="js-svg1">
            <clipPath id="clip1">
              <path d="M0,450.575574 L0,0 L424.903452,0 L452.375,28.5599486 L20.5087638,460.426185 L0,450.575574 Z"></path>
            </clipPath>
            <use xlink:href="#proto-image" clip-path="url(#clip1)" id="js-image1"></use>
          </svg>
        </div>
        <div class="svg-overlay svg-overlay--2">
          <svg viewBox="0 0 480 450" id="js-svg2">
            <clipPath id="clip2">
              <path d="M452.214614,28.6494713 L424.309513,0 L482.040672,0 L452.214614,28.6494713 Z"></path>
            </clipPath>
            <use xlink:href="#proto-image" clip-path="url(#clip2)" id="js-image2"></use>
          </svg>
        </div>
        <div class="svg-overlay svg-overlay--3">
          <svg viewBox="0 0 480 450" id="js-svg3">
            <clipPath id="clip3">
              <path d="M452.320312,28.526424 L482,58 L482,0.066291362 L452.320312,28.526424 Z"></path>
            </clipPath>
            <use xlink:href="#proto-image" clip-path="url(#clip3)" id="js-image3"></use>
          </svg>
        </div>
        <div class="svg-overlay">
          <svg viewBox="0 0 480 450" id="js-svg4">
            <clipPath id="clip4">
              <path d="M452.270844,28.4954427 L482,57.8942871 L482,451 L29.2740886,450.99999 L452.270844,28.4954427 Z"></path>
            </clipPath>
            <use xlink:href="#proto-image" clip-path="url(#clip4)" id="js-image4"></use>
          </svg>
        </div>
      </div>
    </div>
	</div>
	
	<script type="text/javascript" src="login/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src='login/js/howler.min.js'></script>
	<script type="text/javascript" src='login/js/tween.min_1.js'></script>
	<script type="text/javascript" src='login/js/html2canvas.js'></script>
	<script type="text/javascript" src="login/js/index.js"></script>
	<div style="text-align:center;">
<h2 style="color:#7A7676">葫芦娃在线考试系统</h2>

</div>
</body>
</html>