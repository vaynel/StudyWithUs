const menuPages = [
    {
        path: '/menu',
        component: () => import('@/portal/frame/NintendoScreen'),

        children: [
            {
                path: "home",
                component: () => import('@/portal/menu/MenuFrame'),
            }
        ]

    }

]

export { menuPages }