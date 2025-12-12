import { Button, Card } from '@mui/material'
import React from 'react'

export const OrderCard = () => {
  return (
   <Card className='flex items-center justify-between p-5'>
    <div className='flex items-center space-x-2 '>
        <img className='w-16 h-16'src="https://images.pexels.com/photos/1093038/pexels-photo-1093038.jpeg" alt="" />
    </div>
    <div>
        <p>Banana</p>
        <p>Rs.25.00</p>
    </div>
    <div>
        <Button className='cursor-not-allowed'>completed</Button>
    </div>
    </Card>
  )
}
