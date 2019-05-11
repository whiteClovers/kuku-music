<template>
  <transition
    tag="div"
    mode="out-in"
    appear
    :appear-active-class="'animated ' + this.speed + ' ' + this.appearAnimate"
  >
    <slot></slot>
  </transition>
</template>
<script>
  export default {
    name: 'NavBarAnimate',
    data() {
      return {
        appearAnimate: this.$store.state.navbarAnimate,
        speed: this.$store.state.animateSpeed
      }
    },
    computed: {
      CAppearAnimate() {
        return this.$store.state.navbarAnimate
      },
      CSpeed() {
        return this.$store.state.animateSpeed
      }
    },
    watch: {
      CAppearAnimate(val) {
        this.appearAnimate = val
      },
      CSpeed(val) {
        this.speed = val
      },
    },
  }
</script>
