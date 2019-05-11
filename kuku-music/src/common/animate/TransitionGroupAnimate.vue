<template>
  <transition-group
    mode="out-in"
    appear
    :enter-active-class="this.enterActiveClass"
    :leave-active-class="this.leaveActiveClass"
    :appear-active-class="this.appearActiveClass"
  >
    <slot></slot>
  </transition-group>
</template>
<script>
  export default {
    name: 'TransitionGroupAnimate',
    props: ['animateName'],
    data() {
      return {
        enterActiveClass: 'animated ' + this.animateName.enterAnimate,
        leaveActiveClass: 'animated ' + this.animateName.leaveAnimate,
        appearActiveClass: 'animated ' + this.animateName.appearAnimate
      }
    },
  }
</script>
