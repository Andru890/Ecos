import { InputHTMLAttributes, ReactNode } from "react";

interface InputProps extends InputHTMLAttributes<HTMLInputElement> {
  className?: string;
  startIcon?: ReactNode;
  endIcon?: ReactNode;
}

const Input = ({ className = "", startIcon, endIcon, ...props }: InputProps) => {
  return (
    <div
      className={`w-[281px] rounded-[27px] border border-solid border-[#B4B4B4] px-4 py-2 text-[#291117] placeholder-[#291117] outline-none ${className}`}
    >
      {startIcon}
      <input {...props} className="w-full" />
      {endIcon}
    </div>
  );
};

export default Input;
