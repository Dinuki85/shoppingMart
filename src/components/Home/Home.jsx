import React from 'react'
import "./Home.css"
import MultiItemCarousel from './MultiItemCarousel'
import ShopCard from '../Shop/ShopCard'
const shop=[1,1,1,1,1,1,1,1,1,1]
const Home = () => {

  return (
    <div className=''>
      <section className='relative flex flex-col justify-center banner -z-50 item-center'>
        <div className='w-[50w] z-10 text-center'>
          <p className='z-10 py-5 text-2xl lg:text-6xl fond-bold' >Grocery Items</p>
          <p className='z-10 text-xl text-bg-gray-50 lg:text-4xl'>Buy & Enjoy Your Items</p>
        </div>
        <div className='absolute top-0 left-0 right-0 cover'>
          
        </div>
        <div className='fadout'></div>
      </section>

      <secttion className='p-10 lg:py-10 lg:px-20'>
        <p className='py-3 pb-10 text-2xl font-semibold text-gray-400'>Top Grocery Items</p>
        <MultiItemCarousel/>
      </secttion>
      <section classname='px-5 lg:px-20'>
        <h1 clasName='text-2xl font-semibold text-gray-400 py-3'>Shopping with Handpicked Favorites</h1>
        <div>
          {
            shop.map((item)=><ShopCard/>)
          }
          
        </div>
      </section>
    
    
    
    </div>
  )
}

export default Home