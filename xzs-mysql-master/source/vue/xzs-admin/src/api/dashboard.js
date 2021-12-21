import { post } from '@/utils/request'

// 相当于将index函数暴露，暴露接口
// 箭头函数，不带参数
export default {
  //调用utils/request中的post方法，发送请求，查询数据
  index: () => post('/api/admin/dashboard/index')
}
