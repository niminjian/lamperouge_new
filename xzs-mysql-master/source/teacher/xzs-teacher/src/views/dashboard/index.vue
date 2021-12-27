<template>
<!--  <button @click="go">开始考试</button>-->
<!--  <a href="index(1).html">开始考试</a>-->
  <router-link :to="{path:'/dashboard/index(1).html'}" class="link-left">
    <el-button type="primary">开始考试</el-button>
  </router-link>
</template>

<!--<script>-->
<!--  export default {-->
<!--    name: 'test',-->
<!--    methods:{-->
<!--      go(){-->
<!--        this.$router.push('@/views/dashboard/index(1).html')-->
<!--      }-->
<!--    }-->
<!--  }-->
<!--</script>-->
