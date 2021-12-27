<template>
  <button @click="go">开始考试</button>
</template>

<script>
  export default {
    name: 'test',
    methods:{
      go(){
        this.$router.push('@/views/dashboard/index(1).html')
      }
    }
  }
</script>
