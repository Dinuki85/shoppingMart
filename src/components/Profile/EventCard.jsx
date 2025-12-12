import { Card, CardContent, CardMedia, Typography } from '@mui/material'
import React from 'react'

export const EventCard = () => {
  return (
    <div>
        <Card sx={{width:345}}>
            <CardMedia
            
            sx={{height:345}} image='https://content.pexels.com/images/canva/ai-generated-ad/off-theme/ocean_pier_with_thatched_restaurant_at_dusk-full.jpg'/>
    <CardContent>
        <Typography variant='h5' > Sri Lanka Best Grocery Items</Typography>
            <Typography variant='body2' > 50% discount</Typography>
            <div className='py-2 space-y-2'>
    <p>{"mumbai"}</p>
    <p className='text-sm text-blue-500'>15.12.2025</p>
    <p className='text-sm text-red-500'>15.12.2025</p>
            </div>

    </CardContent>
            </Card>
    </div>
  )
}
