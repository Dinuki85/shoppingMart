import { Card } from '@mui/material'
import React from 'react'

const ShopCard = () => {
  return (
    <Card className='m-5 w-[18rem] '>
       <div classame={`${true? 'cursor-pointer':"cursor-not-allowed"}'relative`}>
       <img src="https://pixabay.com/photos/doughnuts-desserts-pastries-treats-1868573/"  alt=""/>


        </div>


    </Card>
  )
}

export default ShopCard