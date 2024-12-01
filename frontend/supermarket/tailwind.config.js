/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/**/*.{js,jsx,ts,tsx}'],
  theme: {
    extend: {
      colors: {
        primary: {
          DEFAULT: '#edf8f3',
          darker: '#1ba99a'
        },
      },
      fontFamily: {
        roboto: ['Roboto', 'sans-serif'],
        proxima: ['ProximaNova', 'sans-serif'],
        DEFAULT: 'roboto'
      },
    },
  },
  plugins: [],
}

