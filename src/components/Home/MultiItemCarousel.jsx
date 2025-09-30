import React from 'react'
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from 'react-slick';
import topGrocery from './topGrocery';
import CarouselItem from './CarouselItem';

const MultiItemCarousel = () => {
  return (
    <div>
        <Slider>
            {topGrocery.map((item)=><CarouselItem 
            image={item.image} 
            title={item.title}/>)}
        </Slider>
    </div>
  )
}

export default MultiItemCarousel