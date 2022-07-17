<template>
  <div>
      <router-view></router-view>
  </div>
</template>

<script>
// import Login from './Login.vue'
// import Register from './Register.vue'
export default {
    name:"User",
    // components:{Login,Register}
    activated() {
        this.$router.push({
            name:"login",
        })
    },
}
</script>

<style>

</style>