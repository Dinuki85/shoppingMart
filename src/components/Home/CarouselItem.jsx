import React from 'react'

const CarouselItem = ({image,title}) => {
  return (
    <div className='flex flex-col items-center justify-center'>
        <img className='w-[10rem] -[10rem] lg:h-[14rem] lg:w-[14rem] rounded-full object-cover object-center' src={image} alt="" />
        <span className='py-5 text-xl font-semibold text-gray-400 '>{title}</span>
    </div>
  )
}

export default CarouselItem