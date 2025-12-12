import React, { useState } from 'react'
import { ProfileNavigation } from './ProfileNavigation'
import UserProfile from './UserProfile';
import { Route, Routes } from 'react-router-dom';
import { Orders } from './Orders';
import { Address } from './Address';
import { Event } from './Event';
import { Favorites } from './Favorites';

const Profile = () => {
    const [openSideBar,setOpenSideBar]=useState(false);
  return (
    
    <div className='justify-between lg:flex'>
        <div className='sticky h-[80vh] lg:w-[20%]'>
            <ProfileNavigation open={openSideBar}/>
        </div>

         <div className='lg:w-[80%]'>
<Routes>
  <Route path='/' element = {<UserProfile/>}/>
  <Route path = 'orders' element={<Orders/>}/>
  <Route path = 'address' element={<Address/>}/>
  <Route path = 'events' element={<Event/>}/>
  <Route path = 'favourites' element={<Favorites/>}/>

  
</Routes>
        </div>
        
    </div>
  )
}

export default Profile