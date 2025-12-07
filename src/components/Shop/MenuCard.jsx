import { Accordion, AccordionDetails, AccordionSummary, Typography } from '@mui/material'
import React from 'react'
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';


const MenuCard = () => {
  return (
     <Accordion>
        <AccordionSummary
          expandIcon={<ExpandMoreIcon />}
          aria-controls="panel1-content"
          id="panel1-header"
        >
          <Typography component="span"> 
            <div className='items-center justify-between lg:flex'>
                <div className='items-center lg:flex lg:gap-5' >
                    <img 
                    className ='w-[7rem] h-[7rem] object-cover'
                    src="https://images.pexels.com/photos/1311771/pexels-photo-1311771.jpeg"
                    alt="" />
                    <div className='space-y-1 lg:space-y-5 lg:max-w-2xl'>
                        <p className='text-2xl font-semibold'>Rice</p>
                        <p>Rs.250.00</p>
                        <p className="text-gray-500">Red Rice will keep your health in a good way</p>
                    </div>
                </div>
            </div>
          </Typography>
        </AccordionSummary>
        <AccordionDetails>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse
          malesuada lacus ex, sit amet blandit leo lobortis eget.
        </AccordionDetails>
      </Accordion>
  )
}

export default MenuCard