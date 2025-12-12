import React from 'react'
import ShopCard from '../Shop/ShopCard'

export const Favorites = () => {
  return (
    <div className=''>
        <h1 className='py-5 text-xl font-semibold text-center'>My Favorites</h1>
    <div className='flex flex-wrap justify-center gap-3'>
        {
            [1,1,1,].map((item)=><ShopCard/>)
        }
        </div>
        
    </div>
  )
}
