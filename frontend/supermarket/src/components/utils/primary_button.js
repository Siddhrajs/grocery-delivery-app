function PrimaryButton({ label, id, onClick, className }) {
  return <button id={id} className={`bg-primary-darker text-white py-2 px-4 font-roboto font-bold hover:shadow-lg ${className}`} onClick={onClick}>{label}</button>;
}

export default PrimaryButton;
