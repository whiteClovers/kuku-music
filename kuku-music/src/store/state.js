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
  isLogin: false,



}




