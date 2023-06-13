const noticePages = [
   
    {
        path: '/notice',
        component: () => import('@/portal/frame/NintendoScreen'),
        children:[
            {
                path: "noticeWrite",
                component: () => import('@/portal/notice/noticeWrite'),
            },
            {
                path: "noticeUpdate",
                component: () => import('@/portal/notice/noticeUpdate'),
            },
            
        ]

    }

]
export { noticePages }
