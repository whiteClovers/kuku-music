<template>
  <transition
    tag="div"
    mode="out-in"
    appear
    :appear-active-class="'animated ' + this.animateName.speed + ' ' + this.animateName.appearAnimate"
    :enter-active-class="'animated ' + this.animateName.speed + ' ' + this.animateName.enterAnimate"
    :leave-active-class="'animated ' + this.animateName.speed + ' ' + this.animateName.leaveAnimate"
  >
    <slot></slot>
  </transition>
</template>
<script>
  export default {
    name: 'RouterViewAnimate',
    data() {
      return {
        animateName: {
          appearAnimate: this.$store.state.navAppearAnimate,
          enterAnimate: this.$store.state.navEnterAnimate,
          leaveAnimate: this.$store.state.navLeaveAnimate,
          speed: this.$store.state.animateSpeed
        },
      }
    },
    computed: {
      EAnimate() {
        return this.$store.state.navEnterAnimate
      },
      LAnimate() {
        return this.$store.state.navLeaveAnimate
      },
      ASpeed() {
        return this.$store.state.animateSpeed
      }
    },
    watch: {
      EAnimate(val) {
        this.animateName.enterAnimate = val
      },
      LAnimate(val) {
        this.animateName.leaveAnimate = val
      },
      ASpeed(val) {
        this.animateName.speed = val
      },
    },
  }
</script>
