import React from 'react'
import Navbar from '../Navbar/Navbar'

import Cart from '../Cart/Cart'
import ShopDetail from '../Shop/ShopDetail'
import { Route, Routes } from 'react-router-dom'
import Profile from '../Profile/Profile'
import { Auth } from '../Auth/Auth'
import Home from '../Home/Home'

const CustomerRouter = () => {
  return (
    <div>
         <Navbar/>
        <Routes>
         
          <Route path='/' element={<Home/>}/>
          <Route path='/account/:register' element={<Home/>}/>
          <Route path='/shop/:city/:title/:id' element={<ShopDetail/>}/>
          <Route path='/cart' element={<Cart/>}/>
          <Route path='/profile/*' element={<Profile/>}/>

        </Routes>
        <Auth/>


    </div>
  )
}

export default CustomerRouter