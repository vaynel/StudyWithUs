import {createRouter, createWebHistory} from 'vue-router'
import { userPages } from '@/router/user-pages'
import {menuPages} from "@/router/menu-pages";
import { StudyRoomPages } from './personalStudyRoom-pages';
import { noticePages } from './notice';


const routes = [
    ...userPages,
    ...menuPages,
    ...noticePages,
    ...StudyRoomPages
]

// 라우터 생성
const router = createRouter({
    history: createWebHistory(),
    routes
})

// 라우터 추출
export { router }