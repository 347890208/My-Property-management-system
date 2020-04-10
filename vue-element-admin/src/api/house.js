import request from '@/utils/request'

export function getHouse(query) {
  return request({
    url: 'http://localhost:8080/house/list/', // 假地址 自行替换
    // url: 'http://localhost:8080/login/',
    method: 'get',
    params: query
  })
}
