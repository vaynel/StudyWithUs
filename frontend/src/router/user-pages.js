const userPages = [
    {
        path: '/user',
        component: () => import('@/portal/frame/NintendoScreen'),

        children: [
            {
                path: "signup",
                component: () => import('@/portal/user/UserSignUpBottom'),
            },
            {
                path: "login",
                component: () => import('@/portal/user/UserLoginBottom'),
            }
        ]

    }

]
export { userPages }