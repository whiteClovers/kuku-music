export default {
  //登录
  userLogin(state, _curUser) {
    sessionStorage.setItem('curUser', JSON.stringify(_curUser))
    state.curUser = _curUser
  },
  userToken(state, _token) {
    sessionStorage.setItem('token', _token)
    state.token = _token
  },
  userLogOut() {
    sessionStorage.removeItem('token')
    sessionStorage.removeItem('curUser')
  },

  //更改导航栏主题
  changeTheme(state, navbarTheme) {
    try {
      localStorage.mirrorTheme = navbarTheme
    } catch (e) {
    }
    state.mirrorTheme = navbarTheme
  },

  //更改背景
  changeBg(state, _bg) {
    try {
      localStorage.bg = _bg
    } catch (e) {
    }
    state.bg = _bg
  },

  //更改遮罩透明度
  changeMaskOpacity(state, _maskOpacity) {
    try {
      localStorage.maskOpacity = _maskOpacity
    } catch (e) {
    }
    state.maskOpacity = _maskOpacity
  },
  changeNavBarAnimate(state, _navbarAnimate) {
    try {
      localStorage.navbarAnimate = _navbarAnimate
    } catch (e) {
    }
    state.navbarAnimate = _navbarAnimate;
  },
  //更改导航进出动画
  changeNavEnterAnimate(state, _navEnterAnimate) {
    try {
      localStorage.navEnterAnimate = _navEnterAnimate
    } catch (e) {
    }
    state.navEnterAnimate = _navEnterAnimate
  },

  changeNavLeaveAnimate(state, _navLeaveAnimate) {
    try {
      localStorage.navLeaveAnimate = _navLeaveAnimate
    } catch (e) {
    }
    state.navLeaveAnimate = _navLeaveAnimate
  },

  //更改左右动画
  changeArticleListAnimate(state, _leftAnimate) {
    try {
      localStorage.leftAnimate = _leftAnimate
    } catch (e) {
    }
    state.leftAnimate = _leftAnimate
  },

  changeRightAnimate(state, _rightAnimate) {
    try {
      localStorage.rightAnimate = _rightAnimate
    } catch (e) {
    }
    state.rightAnimate = _rightAnimate
  },

  //更改动画速度
  changeAnimateSpeed(state, _animateSpeed) {
    try {
      localStorage.animateSpeed = _animateSpeed
    } catch (e) {
    }
    state.animateSpeed = _animateSpeed
  },

  //更改D抽屉
  changeTopDrawer(state, _topDrawerState) {
    state.topDrawer = _topDrawerState
  },
  changeLeftDrawer(state, leftDrawerState) {
    state.leftDrawer = leftDrawerState
  },
  changeRightDrawer(state, rightDrawerState) {
    state.rightDrawer = rightDrawerState
  },

  //更改登录模态框
  changeLoginModal(state, modalState) {
    state.loginModal = modalState
  },
  //更改登录模态框
  changeRegisterModal(state, modalState) {
    state.registerModal = modalState
  }

}
