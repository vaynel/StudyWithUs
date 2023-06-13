const StudyRoomPages = [
    {
        path: '/studyRoom',
        component: () => import('@/portal/frame/NintendoScreen'),

        children: [
            {
                path: "home",
                component: () => import('@/portal/menu/MenuFrame'),
            },

            {
                path: "note",
                component: () => import('@/portal/studyRoom/StudyNote'),
            }
        ]

    }

]

export { StudyRoomPages }