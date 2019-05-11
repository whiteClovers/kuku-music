
// 解析lrc文件展示歌词
function showLRC() {
	var s = "";
	for(var i in oLRC.ms) { //遍历ms数组，把歌词加入列表
		s += '<p>' + oLRC.ms[i].c + '</p>';
	}
	document.getElementById("lyric").innerHTML = s;
}
//showLRC();

/* 输出歌词信息   webURL 是 歌词存放的路径 或者歌词下载的路径   */

var lrc = "";

function getLRC() {
	//				alert("bbb");
	var ajax = new XMLHttpRequest();
	ajax.open("GET", "static/lrc/于文文 - 体面.lrc");
	ajax.onreadystatechange = function() {
		if(ajax.readyState == 4 && ajax.status == 200) {
			lrc = ajax.responseText;
			//			            console.log(lrc);
			//			            alert(lrc.title);
			createLrcObj(lrc);

		}
	};
	ajax.send("aaaaa");
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
	loadFile();
	/*
	for(var i in oLRC){ //查看解析结果
	    console.log(i,":",oLRC[i]);
	}*/
}

//createLrcObj(lrc);


/* ----------------------------------------- */

// 播放歌曲，以及获取歌曲集，歌曲名，图片等信息

/**
 * Loading the tags using the FileAPI.
 */
function loadFile() {
	var file = document.getElementById("file").files[0];
//	alert(file.name);
	//	var url;
	if(file == null) {
		url = "static/music/于文文 - 体面.mp3";
	}
	else {
		url = URL.createObjectURL(file);
	}
	// 将选择的歌曲文件进行播放
	//	alert(file.name);
	//	var url = URL.createObjectURL(file);
	file = "E:/网易云音乐/music/于文文 - 体面.mp3";
//	alert(url);


	document.getElementById("audio").src = url;

	ID3.loadTags(url, function() {
		var tags = ID3.getAllTags(filename);
		alert(tags.comment + " - " + tags.track + ", " + tags.lyrics);
		showTags(url);
	}, 
	{
		tags: ["title", "artist", "album", "picture"],
//		dataReader: ID3.FileAPIReader(file);
	});
}

/**
 * Generic function to get the tags after they have been loaded.
 */
function showTags(url) {
	alert("aaa");
	var tags = ID3.getAllTags(url);
	//    fileClick(url.lyrics);

	document.getElementById('title').textContent = tags.title || "";
	document.getElementById('artist').textContent = tags.artist || "";
	document.getElementById('album').textContent = tags.album || "";

	//    alert(tags.title);alert(tags.artist);alert(tags.album);alert(tags.picture);

	var image = tags.picture;

	if(image) {
		var base64String = "";
		for(var i = 0; i < image.data.length; i++) {
			base64String += String.fromCharCode(image.data[i]);
		}
		var base64 = "data:" + image.format + ";base64," +
			window.btoa(base64String);
		document.getElementById('picture').setAttribute('src', base64);
	} else {
		document.getElementById('picture').style.display = "none";
	}

}