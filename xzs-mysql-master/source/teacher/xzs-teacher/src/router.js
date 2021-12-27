import Vue from 'vue'
import Router from 'vue-router'
import Layout from '@/layout'

Vue.use(Router)
const constantRoutes = [  //存放不需要动态判断权限的路由
  {
    path: '/login',
    name: 'Login',
    hidden: true,
    component: () => import('@/views/login/index'),
    meta: { title: '登录' }
  },
  //首页
  {
    path: '/',  //path设置为"/"，默认显示该界面
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/dashboard/index'),
        name: 'Dashboard',
        meta: { title: '主页', icon: 'home', affix: true }
      }
    ]
  },
  //卷题管理
  {
    path: '/exam',
    component: Layout,
    name: 'ExamPage',
    meta: {
      title: '卷题管理',
      icon: 'exam'
    },
    children: [
      {
        path: 'paper/list',
        component: () => import('@/views/exam/paper/list'),
        name: 'ExamPaperPageList',
        meta: { title: '试卷列表', noCache: true }
      },
      {
        path: 'paper/edit',
        component: () => import('@/views/exam/paper/edit'),
        name: 'ExamPaperEdit',
        meta: { title: '试卷编辑', noCache: true, activeMenu: '/exam/paper/list' },
        hidden: true
      },
      {
        path: 'question/list',
        component: () => import('@/views/exam/question/list'),
        name: 'ExamQuestionPageList',
        meta: { title: '题目列表', noCache: true }
      },
      {
        path: 'question/edit/singleChoice',
        component: () => import('@/views/exam/question/edit/single-choice'),
        name: 'singleChoicePage',
        meta: { title: '单选题编辑', noCache: true, activeMenu: '/exam/question/list' },
        hidden: true
      },
      {
        path: 'question/edit/multipleChoice',
        component: () => import('@/views/exam/question/edit/multiple-choice'),
        name: 'multipleChoicePage',
        meta: { title: '多选题编辑', noCache: true, activeMenu: '/exam/question/list' },
        hidden: true
      },
      {
        path: 'question/edit/trueFalse',
        component: () => import('@/views/exam/question/edit/true-false'),
        name: 'trueFalsePage',
        meta: { title: '判断题编辑', noCache: true, activeMenu: '/exam/question/list' },
        hidden: true
      },
      {
        path: 'question/edit/gapFilling',
        component: () => import('@/views/exam/question/edit/gap-filling'),
        name: 'gapFillingPage',
        meta: { title: '填空题编辑', noCache: true, activeMenu: '/exam/question/list' },
        hidden: true
      },
      {
        path: 'question/edit/shortAnswer',
        component: () => import('@/views/exam/question/edit/short-answer'),
        name: 'shortAnswerPage',
        meta: { title: '简答题编辑', noCache: true, activeMenu: '/exam/question/list' },
        hidden: true
      }
    ]
  },
  //监考
  {
    path: '/monitor',  //path设置为"/"，默认显示该界面
    component: Layout,
    redirect: '/monitor',
    children: [
      {
        path: 'monitor',
        component: () => import('@/views/monitor/index'),
        name: 'monitor',
        meta: { title: '监考', icon: 'eye-open', affix: true }
      }
    ]
  },
  //批阅
  {
    path: '/readover',  //path设置为"/"，默认显示该界面
    component: Layout,
    redirect: '/readover',
    children: [
      {
        path: 'readover',
        component: () => import('@/views/readover/index'),
        name: 'readover',
        meta: { title: '批阅', icon: 'form', affix: true }
      }
    ]
  },
  //考试结果统计
  {
    path: '/resultstatistics',  //path设置为"/"，默认显示该界面
    component: Layout,
    redirect: '/resultstatistics',
    children: [
      {
        path: 'resultstatistics',
        component: () => import('@/views/resultstatistics/index'),
        name: 'resultstatistics',
        meta: { title: '结果统计', icon: 'search', affix: true }
      }
    ]
  }
  // {
  //   path: '/test',  //path设置为"/"，默认显示该界面
  //   component: Layout,
  //   redirect: '/test',
  //   children: [
  //     {
  //       path: 'test',
  //       component: () => import('@/views/test/index(1).html'),
  //       name: 'test',
  //       meta: { title: '考试', icon: 'search', affix: true }
  //     }
  //   ]
  // }
]

const router = new Router({
  routes: constantRoutes
})

export {
  constantRoutes,
  router
}
