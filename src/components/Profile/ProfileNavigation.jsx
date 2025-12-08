import React from 'react'
import ShoppingBagIcon from '@mui/icons-material/ShoppingBag';
import FavoriteIcon from '@mui/icons-material/Favorite';
import HomeIcon from '@mui/icons-material/Home';
import AccountBalanceIcon from '@mui/icons-material/AccountBalance';
import EventAvailableIcon from '@mui/icons-material/EventAvailable';
import ExitToAppIcon from '@mui/icons-material/ExitToApp';
import NotificationsIcon from '@mui/icons-material/Notifications';
import { Divider, Drawer, useMediaQuery } from '@mui/material';
import { useNavigate } from 'react-router-dom';

const menu = [
    { title: "Orders", icon: <ShoppingBagIcon /> },
    { title: "Favourites", icon: <FavoriteIcon /> },
    { title: "Address", icon: <HomeIcon /> },
    { title: "Payments", icon: <AccountBalanceIcon /> },
    { title: "Notifications", icon: <NotificationsIcon /> },
    { title: "Events", icon: <EventAvailableIcon /> },
    { title: "Log Out", icon: <ExitToAppIcon /> }
]
export const ProfileNavigation = ({ open, handleClose }) => {
    const isSmallScreen = useMediaQuery('(max-width:900px)');

    const navigate = useNavigate();
    
    const handleNavigate=(item)=>{
        navigate(`/profile/${item.title.toLoweCase()}`)

    }

    return (
        <div>
            <Drawer variant={isSmallScreen ? "temporary" : "permanent"}
                onClose={handleClose}
                open={true}
                anchor='left'
                sx={{ zIndex: -1, position: "sticky" }}>

                <div className="w-[50vw] lg:w-[20vw] h-[100vh] flex flex-col justify-center text-xl gap-8 pt-16" >
                    {menu.map((item, i) =>
                        <>
                            <div  onClick={()=>handleNavigate(item)} className="flex items-center px-5 space-x-5 cursor-pointer">
                                {item.icon}
                                <span>{item.title}</span>
                            </div>
                            {i !== menu.length - 1 && <Divider />}

                        </>)}
                </div>
            </Drawer>
        </div>
    )
}
