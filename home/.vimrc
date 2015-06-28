version 6.0
if &cp | set nocp | endif
let s:cpo_save=&cpo
set cpo&vim
nmap gx <Plug>NetrwBrowseX
nnoremap <silent> <Plug>NetrwBrowseX :call netrw#NetrwBrowseX(expand("<cfile>"),0)
let &cpo=s:cpo_save
unlet s:cpo_save
set autoindent
set background=dark
set backspace=indent,eol,start
set cmdheight=2
set fileencodings=ucs-bom,utf-8,default,latin1
set helplang=en
set hlsearch
set incsearch
set nomodeline
set mouse=a
set number
set printoptions=paper:letter
set ruler
set runtimepath=~/.vim,/var/lib/vim/addons,/usr/share/vim/vimfiles,/usr/share/vim/vim74,/usr/share/vim/vimfiles/after,/var/lib/vim/addons/after,~/.vim/after
set suffixes=.bak,~,.swp,.o,.info,.aux,.log,.dvi,.bbl,.blg,.brf,.cb,.ind,.idx,.ilg,.inx,.out,.toc
set tags=tags;
set nowrap
" vim: set ft=vim :

" Highlight trailing whitespaces
highlight ExtraWhiteSpace ctermbg=red guibg=red
match ExtraWhiteSpace /\s\+$/
autocmd BufWinEnter * match ExtraWhiteSpace /\s\+$/
autocmd InsertEnter * match ExtraWhiteSpace /\s\+\%#\@<!$/
autocmd InsertLeave * match ExtraWhiteSpace /\s\+$/
autocmd BufWinLeave * call clearmatches()

"
" Configuration for Vundle
"
set nocompatible              " be iMproved, required
filetype off                  " required

" set the runtime path to include Vundle and initialize
set rtp+=~/.vim/bundle/Vundle.vim
call vundle#begin()
" alternatively, pass a path where Vundle should install plugins
"call vundle#begin('~/some/path/here')

" let Vundle manage Vundle, required
Plugin 'gmarik/Vundle.vim'

" The following are examples of different formats supported.
" Keep Plugin commands between vundle#begin/end.
" plugin on GitHub repo
"Plugin 'tpope/vim-fugitive'
" plugin from http://vim-scripts.org/vim/scripts.html
"Plugin 'L9'
" Git plugin not hosted on GitHub
"Plugin 'git://git.wincent.com/command-t.git'
" git repos on your local machine (i.e. when working on your own plugin)
"Plugin 'file:///home/gmarik/path/to/plugin'
" The sparkup vim script is in a subdirectory of this repo called vim.
" Pass the path to set the runtimepath properly.
"Plugin 'rstacruz/sparkup', {'rtp': 'vim/'}
" Avoid a name conflict with L9
"Plugin 'user/L9', {'name': 'newL9'}

" Self-used plugins

Plugin 'scrooloose/nerdtree'
Plugin 'kien/ctrlp.vim'
Plugin 'bling/vim-airline'
Plugin 'majutsushi/tagbar'
Plugin 'Valloric/YouCompleteMe'
Plugin 'brookhong/cscope.vim'

" All of your Plugins must be added before the following line
call vundle#end()            " required
filetype plugin indent on    " required
" To ignore plugin indent changes, instead use:
"filetype plugin on
"
" Brief help
" :PluginList       - lists configured plugins
" :PluginInstall    - installs plugins; append `!` to update or just :PluginUpdate
" :PluginSearch foo - searches for foo; append `!` to refresh local cache
" :PluginClean      - confirms removal of unused plugins; append `!` to auto-approve removal
"
" see :h vundle for more details or wiki for FAQ
" Put your non-Plugin stuff after this line

"
" Basic Settings
"
nmap <silent> <F3> :tabp<CR>
imap <silent> <F3> <ESC>:tabp<CR>
nmap <silent> <F4> :tabn<CR>
imap <silent> <F4> <ESC>:tabn<CR>
nmap <C-S> :w<CR>
imap <C-S> <ESC>:w<CR>
nmap <C-Q> :q<CR>
imap <C-Q> <ESC>:q<CR>
nmap <C-X> :wq<CR>
imap <C-X> <ESC>:wq<CR>

"
" Plugin Settings
"
""" nerdtree
nmap <silent> <F5> :NERDTreeToggle<CR>
imap <silent> <F5> <ESC>:NERDTreeToggle<CR>
""" tagbar
nmap <silent> <F6> :TagbarToggle<CR>
imap <silent> <F6> <ESC>:TagbarToggle<CR>
""" cscope
if has('cscope')
	nnoremap <leader>fa :call CscopeFindInteractive(expand('<cword>'))<CR>
	nnoremap <leader>l :call ToggleLocationList()<CR>
	" s: Find this C symbol
	nnoremap  <leader>fs :call CscopeFind('s', expand('<cword>'))<CR>
	" g: Find this definition
	nnoremap  <leader>fg :call CscopeFind('g', expand('<cword>'))<CR>
	" d: Find functions called by this function
	nnoremap  <leader>fd :call CscopeFind('d', expand('<cword>'))<CR>
	" c: Find functions calling this function
	nnoremap  <leader>fc :call CscopeFind('c', expand('<cword>'))<CR>
	" t: Find this text string
	nnoremap  <leader>ft :call CscopeFind('t', expand('<cword>'))<CR>
	" e: Find this egrep pattern
	nnoremap  <leader>fe :call CscopeFind('e', expand('<cword>'))<CR>
	" f: Find this file
	nnoremap  <leader>ff :call CscopeFind('f', expand('<cword>'))<CR>
	" i: Find files #including this file
	nnoremap  <leader>fi :call CscopeFind('i', expand('<cword>'))<CR>
endif
""" YouCompleteMe
let g:ycm_global_ycm_extra_conf = '~/.vim/.ycm_extra_conf.py'
