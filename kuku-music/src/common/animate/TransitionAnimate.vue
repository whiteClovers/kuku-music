<template>
  <transition
    tag="div"
    mode="out-in"
    appear
    :enter-active-class="this.enterActiveClass"
    :leave-active-class="this.leaveActiveClass"
    :appear-active-class="this.appearActiveClass"
  >
    <slot></slot>
  </transition>
</template>
<script>
  export default {
    name: 'TransitionAnimate',
    props: ['animateName'],
    data() {
      return {
        appearActiveClass: 'animated ' + this.animateName.speed + ' ' + this.animateName.appearAnimate,
        enterActiveClass: 'animated ' + this.animateName.speed + ' ' + this.animateName.enterAnimate,
        leaveActiveClass: 'animated ' + this.animateName.speed + ' ' + this.animateName.leaveAnimate
      }
    },
  }
</script>
