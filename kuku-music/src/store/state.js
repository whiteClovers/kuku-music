let defaultUser = null
let defaultToken = null
let defaultTheme = 'light'
let defaultBg = 'white'
let defaultMaskOpacity = 0

let defaultLeftAnimate = 'zoomIn'
let defaultRightAnimate = 'zoomIn'

let defaultNavbarAnimate = 'flipInX'
let defaultNavAppearAnimate = 'MyAnimateIn'
let defaultNavEnterAnimate = 'MyAnimateIn'
let defaultNavLeaveAnimate = 'MyAnimateOut'

let defaultAnimateSpeed = 'fast'
try {
  if (window.localStorage) {
    console.log("浏览器支持localStorage")
  }
  if (sessionStorage.getItem('token')) {
    defaultToken = sessionStorage.getItem('token')
  }
  if (sessionStorage.getItem('curUser')) {
    var userJsonStr = sessionStorage.getItem('curUser');
    defaultUser = JSON.parse(userJsonStr);
  }

  //主题
  if (localStorage.mirrorTheme) {
    defaultTheme = localStorage.mirrorTheme;
  }
  if (localStorage.bg) {
    defaultBg = localStorage.bg
  }
  //遮罩透明度
  if (localStorage.maskOpacity) {
    defaultMaskOpacity = localStorage.maskOpacity
  }
  //navbar进入动画
  if (localStorage.navbarAnimate) {
    defaultNavbarAnimate = localStorage.navbarAnimate
  }
  //导航切换进入动画
  if (localStorage.navEnterAnimate) {
    defaultNavEnterAnimate = localStorage.navEnterAnimate
  }
  //导航切换离开动画
  if (localStorage.navLeaveAnimate) {
    defaultNavLeaveAnimate = localStorage.navLeaveAnimate
  }
  //左边动画
  if (localStorage.leftAnimate) {
    defaultLeftAnimate = localStorage.leftAnimate
  }
  //右边动画
  if (localStorage.rightAnimate) {
    defaultRightAnimate = localStorage.rightAnimate
  }
  //动画速度
  if (localStorage.animateSpeed) {
    defaultAnimateSpeed = localStorage.animateSpeed
  }
} catch (e) {
}

let rDrawer = false
export default {
  curUser: defaultUser,
  token: defaultToken,

  //navbar动画
  navbarAnimate: defaultNavbarAnimate,
  //导航动画
  navAppearAnimate: defaultNavAppearAnimate,
  //导航进入动画
  navEnterAnimate: defaultNavEnterAnimate,
  //导航离开动画
  navLeaveAnimate: defaultNavLeaveAnimate,
  // 左右动画
  leftAnimate: defaultLeftAnimate,
  rightAnimate: defaultRightAnimate,

  //动画速度
  animateSpeed: defaultAnimateSpeed,

  //默认头像
  // defalutAvatar: "http://media.mirrorming.cn/mirrormingblog/default/weiwenhuaming.png",
  // defalutGifAvatar: "http://media.mirrorming.cn/mirrormingblog/default/avatar.gif",
  // defalutSmallGifAvatar: "http://media.mirrorming.cn/mirrormingblog/default/avatar222x120.gif",

  animateEnterArr: [
    'MyAnimateIn',
    'bounceIn',
    'bounceInDown',
    'bounceInLeft',
    'bounceInRight',
    'bounceInUp',
    'fadeIn',
    'fadeInDown',
    'fadeInDownBig',
    'fadeInLeft',
    'fadeInLeftBig',
    'fadeInRight',
    'fadeInRightBig',
    'fadeInUp',
    'fadeInUpBig',
    'flip',
    'flipInX',
    'flipInY',
    'lightSpeedIn',
    'rotateIn',
    'rotateInDownLeft',
    'rotateInDownRight',
    'rotateInUpLeft',
    'rotateInUpRight',
    'slideInUp',
    'slideInDown',
    'slideInLeft',
    'slideInRight',
    'zoomIn',
    'zoomInDown',
    'zoomInLeft',
    'zoomInRight',
    'zoomInUp',
    'jackInTheBox',
    'rollIn',
  ],


  animateLeaveArr: [
    'MyAnimateOut',
    'bounceOut',
    'bounceOutDown',
    'bounceOutLeft',
    'bounceOutRight',
    'bounceOutUp',
    'fadeOut',
    'fadeOutDown',
    'fadeOutDownBig',
    'fadeOutLeft',
    'fadeOutLeftBig',
    'fadeOutRight',
    'fadeOutRightBig',
    'fadeOutUp',
    'fadeOutUpBig',
    'flip',
    'flipOutX',
    'flipOutY',
    'lightSpeedOut',
    'rotateOut',
    'rotateOutDownLeft',
    'rotateOutDownRight',
    'rotateOutUpLeft',
    'rotateOutUpRight',
    'slideOutUp',
    'slideOutDown',
    'slideOutLeft',
    'slideOutRight',
    'zoomOut',
    'zoomOutDown',
    'zoomOutLeft',
    'zoomOutRight',
    'zoomOutUp',
    'hinge',
    'rollOut',
  ]
}




