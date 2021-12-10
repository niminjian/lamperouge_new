import { post } from '@/utils/request'

// 相当于将index函数暴露，暴露接口 
// 箭头函数，不带参数 
export default {  
  index: () => post('/api/admin/dashboard/index')
}