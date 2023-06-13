const StudyRoomPages = [
    {
        path: '/studyRoom',
        component: () => import('@/portal/frame/NintendoScreen'),

        children: [
            {
                path: "home",
                component: () => import('@/portal/menu/MenuFrame'),
            }
        ]

    }

]

export { StudyRoomPages }