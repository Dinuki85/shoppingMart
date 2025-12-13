import { Card, Chip, IconButton } from '@mui/material'
import React from 'react'
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';

const ShopCard = ({item}) => {
  return (
    <Card className=' w-[18rem] '>
       <div classame={`${true? 'cursor-pointer':"cursor-not-allowed"}'relative`}>
       <img className='w-full h-[10rem] rounded-t-md object-cover'src="https://images.pexels.com/photos/35023463/pexels-photo-35023463.jpeg"  alt=""/>

        <Chip
        size = "small"
        className='absolute top-2 left-2'
        color={true?"success":"error"}
        label={true?"open":"closed"}
        />

        

        </div>
        <div className='justify-between w-full p-4 textPart lg:flex'>
            <p className='text-lg font-semibold'>Sri Lankan Grocery Shops</p>
            <p className='text-sm text-gray-500'>Dive into your favourite Grocery items from ........</p>
            
        </div>

        <div>
            <IconButton>
                {true?<FavoriteIcon/>:<FavoriteBorderIcon/>}
            </IconButton>
        </div>


    </Card>
  )
};

export default ShopCard