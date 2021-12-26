import { post } from '@/utils/request'

export default {
  login: query => post(`/api/user/login`, query),
  logout: query => post(`/api/user/logout`, query)
}
