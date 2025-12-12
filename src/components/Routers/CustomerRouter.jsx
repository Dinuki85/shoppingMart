import React from 'react'
import Navbar from '../Navbar/Navbar'
import { Home, RouteSharp } from '@mui/icons-material'
import Cart from '../Cart/Cart'
import ShopDetail from '../Shop/ShopDetail'
import { Route, Routes } from 'react-router-dom'
import Profile from '../Profile/Profile'

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


    </div>
  )
}

export default CustomerRouter