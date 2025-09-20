import { Avatar, Badge, IconButton } from '@mui/material'
import React from 'react'
import SearchIcon from '@mui/icons-material/Search';
import { red } from '@mui/material/colors';
import AddShoppingCartIcon from '@mui/icons-material/AddShoppingCart';

const Navbar = () => {
    return (
        <div className='flex items-center px-5 z-60 py-[.8rem] bg-blue-300 lg:px-20 justify-between'>
            
                <div className='flex items-center space-x-5 cursor-pointer lg:mr-10'>
                    <li className='font-serif text-2xl font-extrabold logo text-green-950'>
                        Grocery Shop
                    </li>
                


            </div>

            <div className='flex items-center space-x-2 lg:space-x-10'>
                <div className=''>
                    <IconButton >
                        <SearchIcon sx={{fontSize:"1.5rem"}} />
                    </IconButton>
                    
                </div>
                <div className=''>
                    <Avatar sx={{bgcolor:"black",color:red.A200}}>D</Avatar>
                    
                </div>

                 <div className=''>
                    <IconButton >
                        <Badge color="primary" badgeContent={1}>
                            <AddShoppingCartIcon sx={{fontSize:"1.5rem"}} />
                   </Badge>
                    </IconButton>
                       
                        
                    
                </div>

            </div>



        </div>

    )
}

export default Navbar