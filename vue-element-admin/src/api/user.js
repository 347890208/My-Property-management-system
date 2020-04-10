import request from '@/utils/request'

export function login(data) {
  return request({
    url: 'http://localhost:8080/login',
    // url: process.env.VUE_APP_BASE_API + '/vue-element-admin/user/login',
    method: 'post',
    params: data
  })
}

export function getInfo(token) {
  return request({
    url: process.env.VUE_APP_BASE_API + '/vue-element-admin/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: process.env.VUE_APP_BASE_API + '/vue-element-admin/user/logout',
    method: 'post'
  })
}
