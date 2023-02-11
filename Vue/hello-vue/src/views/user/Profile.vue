<template>
<!-- 展示内容必须在标签内 -->
  <div>
    <h1>个人信息</h1>
<!--    接收参数方式1-->
    id：{{$route.params.id}}
<!--    接收参数方式2-->
    id：{{id}}
  </div>
</template>

<script>
export default {
  //接收参数方式2
  props: ['id'],
  name: "UserProfile",
  // 路由钩子
  // 进入前执行
  beforeRouteEnter: (to,from,next)=>{
    console.log('进入路由前');
    next(vm=>{
      vm.getData(); // 进入之前执行方法
    });
  },
  // 离开前执行
  beforeRouteLeave: (to,from,next)=>{
    console.log('离开路由前');
    next();
  },
  methods: {
    getData: function(){
      this.axios({
        method: 'get',
        // 这里是将mode改为history后的访问地址
        url: 'http://localhost:8099/static/mock/data.json'
      }).then(function (response){
        console.log(response)
      });
    }
  }
}
</script>

<style scoped>

</style>
