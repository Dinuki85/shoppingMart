import React from 'react'
import "./Home.css"
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
    
    
    
    </div>
  )
}

export default Home