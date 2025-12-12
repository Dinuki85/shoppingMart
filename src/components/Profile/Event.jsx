import React from 'react'
import { EventCard } from './EventCard'

export const Event = () => {
  return (
    <div className='flex flex-wrap gap-5 px-5 mt-5'>
        {
            [1,1,1,].map((item)=><EventCard/>)
        }

    </div>
  )
}
