import React, { useState } from 'react';

function SMInput({ className, type, label, id }) {
  const [isFocused, setIsFocused] = useState(false);

  const toggleFocus = () => {
    setIsFocused(!isFocused);
  }

  return (
      <div className={className}>
          <label for={id} className={`block px-4 h-4 z-0 transition-all ease-in-out pointer-events-none duration-200 ${isFocused ? 'text-xs translate-y-7 text-gray-600' : 'text-gray-500 translate-y-[33px] text-lg'}`}>
              {label}
          </label>
          <input
              id={id}
              type={type}
              className="border border-gray-300 outline-none h-16 px-4 pt-8 pb-2 z-1 w-full"
              onFocus={toggleFocus}
              onBlur={toggleFocus}
          />
      </div>
  ); 
}

export default SMInput;
