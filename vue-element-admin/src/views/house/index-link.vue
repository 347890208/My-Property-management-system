<template>
  <div>{{ info.id }}显示</div>
</template>

<script>
export default {
  name: 'Index',
  //   props: ['id'],
  data() {
    return {
      info: {
        'id': '123',
        'num': '',
        'dep': '',
        'type': '',
        'area': '',
        'sell': '',
        'unit': '',
        'floor': '',
        'direction': '',
        'memo': '',
        'ownerid': ''
      }

    }
  },
  beforeRouteEnter: (to, from, next) => {
    console.log('准备进入')
    next(vm => {
      vm.getData()
      console.log('getdata')
    })
  },
  beforeRouteLeave: (to, from, next) => {
    console.log('准备离开')
    next()
  },
  methods: {
    getData: function() {
      this.axios({
        method: 'get',
        url: 'http://localhost:8080/house/resource/121'
      })
        .then((response) => {
          // 因为层级比较深，匿名函数会导致this指向发生改变
          // 这个时候使用箭头函数解决
          alert(this)
          this.info = response.data
          console.log(response.data)
        })
        .catch(function(error) {
          console.log(error)
        })
    }
  }
}
</script>

<style>

</style>
