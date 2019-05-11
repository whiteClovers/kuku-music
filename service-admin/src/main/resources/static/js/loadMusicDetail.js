/*
  解析歌曲名，专辑名等信息
 * */
		var $ = function(e) {
				return document.getElementById(e);
			};

			function loadUrl(url, callback, reader) {
//				alert(url);
				var startDate = new Date().getTime();
				ID3.loadTags(url, function() {
					var endDate = new Date().getTime();
					if(typeof console !== "undefined") console.log("Time: " + ((endDate - startDate) / 1000) + "s");
					var tags = ID3.getAllTags(url);
					$("artist").textContent = tags.artist || "";
					$("title").textContent = tags.title || "";
					$("album").textContent = tags.album || "";
					$("artist").textContent = tags.artist || "";
//					$("year").textContent = tags.year || "";
//					$("comment").textContent = (tags.comment || {}).text || "";
//					$("genre").textContent = tags.genre || "";
//					$("track").textContent = tags.track || "";
//					$("lyrics").textContent = (tags.lyrics || {}).lyrics || "";
					if("picture" in tags) {
						var image = tags.picture;
						var base64String = "";
						for(var i = 0; i < image.data.length; i++) {
							base64String += String.fromCharCode(image.data[i]);
						}
						$("art").src = "data:" + image.format + ";base64," + window.btoa(base64String);
						$("art").style.display = "block";
					} else {
						$("art").style.display = "none";
					}
					if(callback) {
						callback();
					};
				}, {
					tags: ["artist", "title", "album", "year", "comment", "track", "genre", "lyrics", "picture"],
					dataReader: reader
				});
				
			}

			/*function loadFromLink(link) {
				var loading = link.parentNode.getElementsByTagName("img")[0];
				var url = link.href;

				loading.style.display = "inline";
				loadUrl(url, function() {
					loading.style.display = "none";
				});
			}

			function loadFromFile(file) {
				var url = file.urn || file.name;
				loadUrl(url, null, FileAPIReader(file));
			}

			function load(elem) {
				if(elem.id === "file") {
					alert("aaa")
					loadAudio(elem.files[0]);
					loadFromFile(elem.files[0]);
				} else {
					alert("bbb")
					loadAudio(elem)
					loadFromLink(elem);
				}
			}
			function loadAudio(file){
				var audioUrl=getObjectURL(file);

				$("audio").src=audioUrl;
				$("audio").play();
			}

			<!--把文件转换成可读URL-->
			function getObjectURL(file) {
				var url = null;
				if(window.createObjectURL != undefined) { // basic
					url = window.createObjectURL(file);
					console.info(url);
				} else if(window.URL != undefined) { // mozilla(firefox)
					url = window.URL.createObjectURL(file);
					console.info(url);
				} else if(window.webkitURL != undefined) { // webkit or chrome
					url = window.webkitURL.createObjectURL(file);
					console.info(url);
				}
				console.info("file:::::" + url);
				getLRC();
				return url;
			}*/
			
/* 解析歌词  */
//static/music/于文文 - 体面.mp3
//static/lrc/于文文 - 体面.lrc

	var lrc = "";
			function getLRC() {
			    var ajax = new XMLHttpRequest();
			    var lrcUrl = audioSrc.replace('music','lrc').replace('mp3','lrc');
//			    alert("lrcUrl :"+lrcUrl);
			    ajax.open("GET", lrcUrl ,true);
			    ajax.onreadystatechange = function () {
			        if (ajax.readyState == 4 && ajax.status == 200) {
			            lrc = ajax.responseText;
			            console.log(lrc);
			            createLrcObj(lrc);
			        }
			    };
			    ajax.send(null);
			}
			
var oLRC = {
	ti: "", //歌曲名
	ar: "", //演唱者
	al: "", //专辑名
	by: "", //歌词制作人
	offset: 0, //时间补偿值，单位毫秒，用于调整歌词整体位置
	ms: [] //歌词数组{t:时间,c:歌词}
};

function createLrcObj(lrc) {
	if(lrc.length == 0) return;
	var lrcs = lrc.split('\r\n'); //用回车拆分成数组
	for(var i in lrcs) { //遍历歌词数组
		lrcs[i] = lrcs[i].replace(/(^\s*)|(\s*$)/g, ""); //去除前后空格
		var t = lrcs[i].substring(lrcs[i].indexOf("[") + 1, lrcs[i].indexOf("]")); //取[]间的内容
		var s = t.split(":"); //分离:前后文字
		if(isNaN(parseInt(s[0]))) { //不是数值
			for(var i in oLRC) {
				if(i != "ms" && i == s[0].toLowerCase()) {
					oLRC[i] = s[1];
				}
			}
		} else { //是数值
			var arr = lrcs[i].match(/\[(\d+:.+?)\]/g); //提取时间字段，可能有多个
			var start = 0;
			for(var k in arr) {
				start += arr[k].length; //计算歌词位置
			}
			var content = lrcs[i].substring(start); //获取歌词内容
			for(var k in arr) {
				var t = arr[k].substring(1, arr[k].length - 1); //取[]间的内容
				var s = t.split(":"); //分离:前后文字
				oLRC.ms.push({ //对象{t:时间,c:歌词}加入ms数组
					t: (parseFloat(s[0]) * 60 + parseFloat(s[1])).toFixed(3),
					c: content
				});
			}
		}
	};
	oLRC.ms.sort(function(a, b) { //按时间顺序排序
		return a.t - b.t;
	});
	
	showLRC();
}

// 解析lrc文件展示歌词
function showLRC() {
	var s = "";
	for(var i in oLRC.ms) { //遍历ms数组，把歌词加入列表
		s += '<p>' + oLRC.ms[i].c + '</p>';
	}
	document.getElementById("lyric").innerHTML = s;
}
//F:\Hbuilder\bootstrap_action\static\music
//static/music/于文文 - 体面.mp3

//E:\网易云音乐\下载

		var a = GetRequest();
		//console.log("name:"+a['name']); //打印出传过来的id
		//		alert("name:"+a['name']);
		var audioSrc = a['name'];
		document.getElementById("audio").src = audioSrc;

//		File aa = new File("F:\Hbuilder\bootstrap_action\static\music");
		loadUrl(audioSrc, function() {
					loading.style.display = "none";
				});

		getLRC();
		
		function GetRequest() {
			var url = location.search; //获取url中"?"符后的字串
			var theRequest = new Object(); 
			if(url.indexOf("?") != -1) {    
				var str = url.substr(1);    
				strs = str.split("&");    
				for(var i = 0; i < strs.length; i++) {      
					theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);    
				}  
			}  
			return theRequest;
		}